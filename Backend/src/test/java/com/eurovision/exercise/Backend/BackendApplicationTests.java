package com.eurovision.exercise.Backend;

import com.eurovision.exercise.Backend.model.City;
import com.eurovision.exercise.Backend.repo.CityRepo;
import com.eurovision.exercise.Backend.services.CityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BackendApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private CityService cityService;

	@MockBean
	private CityRepo cityRepo;

	@Test
	void getLargestSequenceOfIncreasingIds() throws Exception{
		List<City> list = new ArrayList<City>(){{
			add(new City(1, "Avila"));
			add(new City(10, "Barcelona"));
			add(new City(2,"Ciudad Real"));
			add(new City(3, "Frankfurt"));
			add(new City(4, "Granada"));
			add(new City(5, "Hamburg"));
		}};

		List<Integer> resultList = cityService.getLargestSequenceOfIncreasingIds(list);

		List<Integer> expectedList = new ArrayList<Integer>(){{
			add(2);
			add(3);
			add(4);
			add(5);
		}};

		assertEquals(expectedList, resultList);
	}
}
