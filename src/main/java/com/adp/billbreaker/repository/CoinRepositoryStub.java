package com.adp.billbreaker.repository;

import java.util.LinkedList;
import java.util.List;

import com.adp.billbreaker.domain.Coin;

public class CoinRepositoryStub {
	
	private static List<Coin> coinList = new LinkedList<>();
	
	static {						
		coinList.add(new Coin(0.25, 100));
		coinList.add(new Coin(0.10, 100));
		coinList.add(new Coin(0.05, 100));
		coinList.add(new Coin(0.01, 100));
	}
	
	public static List<Coin> getCoinList() {
		return coinList;
	}

}
