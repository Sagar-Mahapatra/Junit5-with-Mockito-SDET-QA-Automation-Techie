package com.sqat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sqat.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
