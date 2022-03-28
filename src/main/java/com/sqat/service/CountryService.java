package com.sqat.service;

import java.util.List;

import com.sqat.exception.CountryNotFoundException;
import com.sqat.model.Country;

public interface CountryService {

	List<Country> getAllCountries() throws CountryNotFoundException;

	Country getCountry(Integer id) throws CountryNotFoundException;

	Country addCountry(Country country) throws CountryNotFoundException;

	void removeCountry(Integer id) throws CountryNotFoundException;

}
