package com.garden.spring.test.thymeleaf.domain;

import java.time.LocalDateTime;

public class Weatherhistory {

	private LocalDateTime date;
	private String weather;
	private double temperatures;
	private double precipitation;
	private String microDust;
	private double windSpeed;
	
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public double getTemperatures() {
		return temperatures;
	}
	public void setTemperatures(double temperatures) {
		this.temperatures = temperatures;
	}
	public double getPrecipitation() {
		return precipitation;
	}
	public void setPrecipitation(double precipitation) {
		this.precipitation = precipitation;
	}
	public String getMicroDust() {
		return microDust;
	}
	public void setMicroDust(String microDust) {
		this.microDust = microDust;
	}
	public double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
	
	
}
