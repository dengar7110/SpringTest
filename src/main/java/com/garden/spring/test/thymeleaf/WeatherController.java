package com.garden.spring.test.thymeleaf;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.garden.spring.test.thymeleaf.domain.Weatherhistory;
import com.garden.spring.test.thymeleaf.service.WeatherhistoryService;

@Controller
@RequestMapping("/thymeleaf/weather")
public class WeatherController {
	
	@Autowired
	private WeatherhistoryService weatherhistoryService;
	
	@GetMapping("/list")
	public String weatherhistory(Model model) {
		
		List<Weatherhistory> weatherhistoryList = new ArrayList<>();
		
		weatherhistoryList =  weatherhistoryService.getWeatherhistoryList();
		
		model.addAttribute("weatherhistoryList", weatherhistoryList);
		
		return "/thymeleaf/weather/list";
	}
	
	@GetMapping("/input")
	public String weatherInput() {
		
		return "/thymeleaf/weather/input";
	}
	
	@PostMapping("/input")
	public String addweatherhistory(
			@RequestParam("date") String date
			, @RequestParam("weather") String weather
			, @RequestParam("temperatures") double temperatures
			, @RequestParam("precipitation") double precipitation
			, @RequestParam("microDust") String microDust
			, @RequestParam("windSpeed") double windSpeed){
		
		weatherhistoryService.addWeatherhistory(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		return "redirect:/thymeleaf/weather/list";
	}

}
