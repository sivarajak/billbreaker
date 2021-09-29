package com.adp.billbreaker.dto;

import java.util.List;

public class ChangeDTO {
	
	private List<CoinDTO> coinList;

	public ChangeDTO(List<CoinDTO> coinList) {
		super();
		this.coinList = coinList;
	}

	public List<CoinDTO> getCoinList() {
		return coinList;
	}

	public void setCoinList(List<CoinDTO> coinList) {
		this.coinList = coinList;
	}
	
	

}
