package com.arya.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arya.spring.model.WeatherInfoModel;
import com.arya.spring.service.WeatherService;

@Controller
public class WeatherController {

	private static final Logger logger = Logger.getLogger(WeatherController.class);

	@Autowired
	private WeatherService weatherService;
	
	
	
	// API :: http://localhost:8080/weather-app/
	
	@GetMapping("/")
	public String hello(Model model) {
		return "welcome";
	}

	
	
	// API :: http://localhost:8080/weather-app/weather.htm
	
	@RequestMapping(value = "weather", method = RequestMethod.POST)
	public String weather(HttpServletRequest req, HttpServletResponse res, Model model) {

		// logs debug message
		if (logger.isDebugEnabled()) {
			logger.debug("Inside WeatherController-weather()");
		}

		List<WeatherInfoModel> weatherInfoModels = new ArrayList<>();

		String city = req.getParameter("city");

		try {
			weatherInfoModels = weatherService.getWeatherInfoByCity(city);
		} catch (Exception e) {
			logger.error("Error occured while fetching weather by city name ", e);
		}

		System.out.println(city);
		model.addAttribute("city", city);
		model.addAttribute("weatherInfoModels", weatherInfoModels);

		return "loginsuccess";

	}

	
	
	// API :: http://localhost:8080/weather-app/London
	
	@RequestMapping(value = "/{city}", method = RequestMethod.GET)
	public @ResponseBody List<WeatherInfoModel> weatherByCityPathVar(@PathVariable String city) {

		logger.info("Inside WeatherController - weatherByCityPathVar()");
		List<WeatherInfoModel> weatherInfoModels = new ArrayList<>();

		try {
			weatherInfoModels = weatherService.getWeatherInfoByCity(city);
		} catch (Exception e) {
			logger.error("Error occured while fetching weather by city name ", e);
		}

		return weatherInfoModels;
	}
	
	
	
	// API :: http://localhost:8080/weather-app/city?name=London
	
	@RequestMapping(value = "/city", method = RequestMethod.GET)
	public @ResponseBody List<WeatherInfoModel> weatherByCityReqParam(@RequestParam("name") String city) {

		logger.info("Inside WeatherController - weatherByCityReqParam()");
		List<WeatherInfoModel> weatherInfoModels = new ArrayList<>();

		try {
			weatherInfoModels = weatherService.getWeatherInfoByCity(city);
		} catch (Exception e) {
			logger.error("Error occured while fetching weather by city name ", e);
		}

		return weatherInfoModels;
	}

}
