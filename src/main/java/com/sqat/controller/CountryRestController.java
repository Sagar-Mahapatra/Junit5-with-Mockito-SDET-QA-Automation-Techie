package com.sqat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sqat.exception.CountryNotFoundException;
import com.sqat.model.Country;
import com.sqat.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryRestController {

	@Autowired
	private CountryService service;

	@GetMapping("/")
	public ResponseEntity<List<Country>> getAllCountries() throws CountryNotFoundException {
		List<Country> countriesList = service.getAllCountries();
		return new ResponseEntity<List<Country>>(countriesList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Country> getCountry(@PathVariable Integer id) throws CountryNotFoundException {
		Country country = service.getCountry(id);
		return new ResponseEntity<Country>(country, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Country> addCountry(@RequestBody Country country) throws CountryNotFoundException {
		Country addedCountry = service.addCountry(country);
		return new ResponseEntity<Country>(addedCountry, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCountry(@PathVariable Integer id) throws CountryNotFoundException {
		service.removeCountry(id);
		return new ResponseEntity<String>("DELETED", HttpStatus.OK);
	}

}
