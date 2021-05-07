package com.eurovision.exercise.Backend.services;

import com.eurovision.exercise.Backend.model.City;
import com.eurovision.exercise.Backend.repo.CityRepo;
import javafx.scene.control.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepo cityRepo;

    @Autowired
    public CityService(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    public List<City> getAllCity(){
        return cityRepo.findAll();
    }

    public Page<City> getCitiesByPagination(int page, int size){
        return cityRepo.findAll(PageRequest.of(page,size));
    }
}
