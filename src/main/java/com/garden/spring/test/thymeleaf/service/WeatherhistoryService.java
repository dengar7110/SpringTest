package com.garden.spring.test.thymeleaf.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garden.spring.test.thymeleaf.domain.Weatherhistory;
import com.garden.spring.test.thymeleaf.repository.WeatherhistoryRepository;

@Service
public class WeatherhistoryService {

	@Autowired
	private WeatherhistoryRepository weatherhistoryRespoitory;
	
	public List<Weatherhistory> getWeatherhistoryList() {
		List<Weatherhistory> weatherhistoryList = weatherhistoryRespoitory.selectWeatherhistoryList();
		return weatherhistoryList;
	}
	
	public int addWeather(
			LocalDate date 
			, String weather
			, double temperatures
			, double precipitation
			, String microDust
			, double windSpeed) {
		
		return weatherhistoryRespoitory.insertWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
	}
	
}
