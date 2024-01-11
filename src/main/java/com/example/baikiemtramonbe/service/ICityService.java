package com.example.baikiemtramonbe.service;

import com.example.baikiemtramonbe.model.City;
import java.util.List;

public interface ICityService {
    List<City> findAll();

    void save(City city);

    City findById(int id);

    void update(int id, City city);

    void remove(int id);
}