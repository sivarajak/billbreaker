package com.adp.billbreaker.service;

import com.adp.billbreaker.dto.ChangeDTO;

public interface IBreakerService {
	
	ChangeDTO billBreak(double billAmount, String type);

}
