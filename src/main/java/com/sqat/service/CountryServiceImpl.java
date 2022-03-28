package com.sqat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sqat.dao.CountryRepository;
import com.sqat.exception.CountryNotFoundException;
import com.sqat.model.Country;

@Service
public class CountryServiceImpl implements CountryService {

	private CountryRepository repo;

	public CountryServiceImpl(CountryRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Country> getAllCountries() throws CountryNotFoundException {
		List<Country> list = repo.findAll();
		if (list.isEmpty()) {
			System.out.println("NOT FOUND");
			throw new CountryNotFoundException("404", "NOT FOUND");
		} else {
			return list;
		}
	}

	@Override
	public Country getCountry(Integer id) throws CountryNotFoundException {
		return repo.findById(id).orElseThrow(() -> new CountryNotFoundException("404", "NOT FOUND"));
	}

	@Override
	public Country addCountry(Country country) throws CountryNotFoundException {
		return repo.save(country);
	}

	@Override
	public void removeCountry(Integer id) throws CountryNotFoundException {
		boolean res = repo.existsById(id);
		if (res) {
			repo.deleteById(id);
		} else {
			System.out.println("NOT FOUND");
			throw new CountryNotFoundException("404", "NOT FOUND");
		}

	}
}
