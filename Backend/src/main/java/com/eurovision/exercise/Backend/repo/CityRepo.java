package com.eurovision.exercise.Backend.repo;

import com.eurovision.exercise.Backend.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City, Integer> { }
