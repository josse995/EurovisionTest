package com.eurovision.exercise.Backend;

import com.eurovision.exercise.Backend.model.City;
import com.eurovision.exercise.Backend.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> getAllCities(){
        return cityService.getAllCity();
    }

    @GetMapping("queryByPage")
    public Map getCityByPagination(@RequestParam("page") int page, @RequestParam("size") int size){
        Page<City> pages = cityService.getCitiesByPagination(page, size);

        //Take only fields requested according to Interview Exercise PDF
        Map map = new HashMap();
        map.put("content", pages.getContent());
        map.put("totalPages", pages.getTotalPages());
        map.put("totalElements", pages.getTotalElements());

        return map;
    }
}
