package com.adp.billbreaker.controller;

import javax.validation.constraints.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.adp.billbreaker.constants.IConstants;
import com.adp.billbreaker.dto.ChangeDTO;
import com.adp.billbreaker.service.IBreakerService;

@RequestMapping(value = "/billbreaker/v1")
@RestController
@Validated
public class ChangeController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IBreakerService breakerService;
	
	@GetMapping(value = "/breakit", produces = { IConstants.APPLICATION_JSON })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ChangeDTO breakit(@RequestParam(name = "billValue") @Pattern(regexp = IConstants.BILL_PATTERN_REGEX, 
				message = IConstants.INVALID_AMOUNT_ERROR_MSG) String billValue, 
				@RequestParam(defaultValue = "minCoins") String breakType) {
		
    	logger.info("breakit -> Bill Value : "+ billValue + " Break Type : " + breakType) ;
    	
    	
		return breakerService.billBreak(Double.valueOf(billValue), breakType);
	}

}
