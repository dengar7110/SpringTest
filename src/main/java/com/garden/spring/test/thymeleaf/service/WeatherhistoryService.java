package com.garden.spring.test.thymeleaf.service;

import java.time.LocalDateTime;
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
	
	public int addWeatherhistory(
								String date 
								, String weather
								, double temperatures
								, double precipitation
								, String microDust
								, double windSpeed) {
		
		return weatherhistoryRespoitory.insertWeatherhistory(date, weather, temperatures, precipitation, microDust, windSpeed);

	}
	
}
