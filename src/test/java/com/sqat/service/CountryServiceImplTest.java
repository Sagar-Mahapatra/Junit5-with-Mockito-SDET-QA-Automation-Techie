package com.sqat.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.sqat.dao.CountryRepository;
import com.sqat.exception.CountryNotFoundException;
import com.sqat.model.Country;

@SpringBootTest(classes = CountryServiceImplTest.class)
public class CountryServiceImplTest {

	@Mock
	private CountryRepository repo;

	@InjectMocks
	private CountryServiceImpl service;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testGetAllCountries() throws CountryNotFoundException {
		List<Country> myCountries = new ArrayList<>();
		myCountries.add(new Country(1, "India", "91"));
		when(repo.findAll()).thenReturn(myCountries);
		List<Country> list = service.getAllCountries();
		assertEquals(myCountries.size(), list.size());
	}

}
