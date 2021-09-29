package com.adp.billbreaker.service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.adp.billbreaker.constants.IConstants;
import com.adp.billbreaker.domain.Coin;
import com.adp.billbreaker.dto.ChangeDTO;
import com.adp.billbreaker.dto.CoinDTO;
import com.adp.billbreaker.exception.InvalidBreakTypeException;
import com.adp.billbreaker.exception.NotEnoughCoinsAvailableException;
import com.adp.billbreaker.repository.CoinRepository;

@Service
public class BreakerServiceImpl implements IBreakerService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CoinRepository coinRepository;
		
	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ)
	public ChangeDTO billBreak(double billAmount, String type) {

		double billValue = billAmount;		
		List<Coin> coinList = coinRepository.findAll();
		List<Coin> sortedCoinList = null;
		
		if(IConstants.MIN_COINS.equalsIgnoreCase(type)) {
			
			sortedCoinList = coinList.stream().sorted(Comparator.comparingDouble(Coin::getValue).reversed())
				.collect(Collectors.toList());
			
		} else if(IConstants.MAX_COINS.equalsIgnoreCase(type)) {
			
			sortedCoinList = coinList.stream().sorted(Comparator.comparingDouble(Coin::getValue))
					.collect(Collectors.toList());
		} else {
			throw new InvalidBreakTypeException("Bill Break Type is not valid. It should be either maxcoins or mincoins");
		}
				
		int totalCoinDenom = sortedCoinList.size();
		
		List<CoinDTO> issuedCoinList = new LinkedList<>();
		
		for(int i = 0; i < totalCoinDenom; i++) {
			
			int issuedCoinCount = 0;
			Coin coin = sortedCoinList.get(i);
			double coinValue = coin.getValue();
			int coinCount = coin.getCount();
			double totalCoinValue = coinValue * coinCount;
			
			if(billValue >= totalCoinValue) {
				
				issuedCoinCount = coinCount;
				issuedCoinList.add(i, new CoinDTO(coinValue, coinCount));
				billValue = billValue - totalCoinValue;
				
			} else {
				
				issuedCoinCount = (int) (billValue/coinValue);
				issuedCoinList.add(i, new CoinDTO(coinValue, issuedCoinCount));
				billValue = billValue - (coinValue * issuedCoinCount);
				
			}
			
			if(billValue == 0) {
				break;
			}
			
		}
		
		if(billValue != 0) {
			logger.info("Not Enough Coin Available for the given bill");
			throw new NotEnoughCoinsAvailableException("Not Enough Coin Available for the given bill amount" + billAmount);
			
		} else {
			for(int j = 0; j < issuedCoinList.size(); j++) {
				Coin coin = sortedCoinList.get(j);
				CoinDTO issuedCoin = issuedCoinList.get(j);
				coin.setCount(coin.getCount() - issuedCoin.getCount());
				coinRepository.save(coin);
				System.out.println(issuedCoin);
			}
		}
				
		return new ChangeDTO(issuedCoinList);
	}

}
