package com.example.demo.service;

import com.example.demo.model.City;
import com.example.demo.model.Weather;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoService {

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private CityRepository cityRepository;

    //@GetMapping("/weathers")   // GET Method for reading operation
    public List<Weather> listWeather(String city, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("date").descending());

        return weatherRepository.listWeather(city, pageable);
    }

    //@PutMapping("/weather/{weather}")    // PUT Method for Update operation
    public Weather saveWeather(Weather weather) {
        return weatherRepository.save(weather);
    }

    //@GetMapping("/weather")   // GET Method for reading operation
    public Weather getWeather(Long id) {
        return weatherRepository.findById(id).orElse(null);
    }

    //@DeleteMapping("/weather/{id}")    // DELETE Method for Delete operation
    public Boolean deleteWeather(Long id) {
        Weather weather = weatherRepository.findById(id).orElse(null);
        if (weather == null) {
            return true;
        }

        weather.setIs_del(1);
        weatherRepository.save(weather);
        return true;
    }

    //@GetMapping("/city")   // GET Method for reading operation
    public City getCity(String name) {
        return cityRepository.findByName(name);
    }

    //@PutMapping("/city/{id}")    // PUT Method for Update operation
    public City saveCity(City city) {
        return cityRepository.save(city);
    }
}
