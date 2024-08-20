package com.garden.spring.test.thymeleaf.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.garden.spring.test.thymeleaf.domain.Weatherhistory;

@Mapper
public interface WeatherhistoryRepository {
	
	public List<Weatherhistory> selectWeatherhistoryList();

	public int insertWeatherhistory(
			@Param("date") String date
			, @Param("weather") String weather
			, @Param("temperatures") double temperatures
			, @Param("precipitation") double precipitation
			, @Param("microDust") String microDust
			, @Param("windSpeed") double windSpeed);
	
}
