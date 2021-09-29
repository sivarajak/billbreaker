package com.adp.billbreaker.constants;

public interface IConstants {
	
	String APPLICATION_JSON = "application/json";
	
	String MAX_COINS = "maxCoins";
	
	String MIN_COINS = "minCoins";
	
	String INVALID_AMOUNT_ERROR_MSG = "Invalid Amount. The bill value should be either of 1, 2, 5, 10, 20, 50,  100";
	
	String BILL_PATTERN_REGEX = "^(1|2|5|10|20|50|100)$";
	
	

}
