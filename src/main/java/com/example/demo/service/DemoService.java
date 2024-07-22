package com.example.demo.service;

import com.example.demo.model.City;
import com.example.demo.model.Weather;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.WeatherRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

	private static final Logger logger = LogManager.getLogger(DemoService.class);
    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private CityRepository cityRepository;

    public List<Weather> listWeather(String city, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("date").descending());

        return weatherRepository.listWeather(city, pageable);
    }

    public Weather saveWeather(Weather weather) {
        return weatherRepository.save(weather);
    }

    public Weather getWeather(Long id) {
        return weatherRepository.findById(id).orElse(null);
    }

     public Boolean deleteWeather(Long id) {
        Weather weather = weatherRepository.findById(id).orElse(null);
        if (weather == null) {
            return true;
        }

        weather.setIs_del(1);
        weatherRepository.save(weather);
        return true;
    }

     public City getCity(String name) {
        return cityRepository.findByName(name);
    }

    public City saveCity(City city) {
        return cityRepository.save(city);
    }
}
