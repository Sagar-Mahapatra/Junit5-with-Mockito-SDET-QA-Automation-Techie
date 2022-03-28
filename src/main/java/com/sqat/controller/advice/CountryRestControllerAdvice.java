package com.sqat.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sqat.exception.CountryNotFoundException;
import com.sqat.model.CountryResp;

@RestControllerAdvice
public class CountryRestControllerAdvice {

	@ExceptionHandler(CountryNotFoundException.class)
	public ResponseEntity<CountryResp> handleCountryNotFoundException(CountryNotFoundException e) {
		CountryResp countryResp = new CountryResp(e.getRespCode(), e.getRespMsg());
		return new ResponseEntity<CountryResp>(countryResp, HttpStatus.NOT_FOUND);
	}

}
