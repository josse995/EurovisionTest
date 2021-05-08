package com.eurovision.exercise.Backend.services;

import com.eurovision.exercise.Backend.model.City;
import com.eurovision.exercise.Backend.repo.CityRepo;
import javafx.scene.control.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return cityRepo.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "name")));
    }

    public List<Integer> getLargestSequenceOfIncreasingIds(){
        return getLargestSequenceOfIncreasingIds(cityRepo.findAll(Sort.by(Sort.Direction.ASC, "name")));
    }

    public List<Integer> getLargestSequenceOfIncreasingIds(List<City> list){

        int maxCount = 1,  maxStart = 0, currCount = 1, currStart = 0;
        for (int i = 1; i < list.size(); ++i){

            if(list.get(i).getId() >= list.get(i-1).getId()){
                ++currCount;
            }else{
                if(currCount > maxCount){
                    maxCount = currCount;
                    maxStart = currStart;
                }
                currStart = i;
                currCount = 1;
            }
        }

        if(currCount > maxCount){
            maxCount = currCount;
            maxStart = currStart;
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < maxCount; ++i){
            result.add(list.get(i + maxStart).getId());
        }
        return result;
    }
}
