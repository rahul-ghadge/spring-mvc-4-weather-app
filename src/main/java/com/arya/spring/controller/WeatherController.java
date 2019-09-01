package com.arya.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arya.spring.exception.EmptyCityNameException;
import com.arya.spring.model.WeatherInfoModel;
import com.arya.spring.service.WeatherService;
import com.arya.spring.utils.ConstantUtils;

@Controller
public class WeatherController {

	private static final Logger logger = Logger.getLogger(WeatherController.class);

	@Autowired
	private WeatherService weatherService;

	
	/*
	 * API to redirect on welcome page 
	 * 
	 * http://localhost:8080/weather-app/
	 */
	@GetMapping("/")
	public String hello(Model model) {
		return "welcome";
	}

	

	/*
	 * API to get weather data from external API and send to UI
	 * http://localhost:8080/weather-app/weather.htm
	 * 
	 * @param HttpServletRequest req,
	 * 
	 * @param HttpServletResponse res,
	 * 
	 * @paramModel model
	 */
	@RequestMapping(value = "weather", method = RequestMethod.POST)
	public String weather(HttpServletRequest req, HttpServletResponse res, Model model) throws EmptyCityNameException {

		if (logger.isDebugEnabled()) {
			logger.debug("Inside WeatherController-weather()");
		}

		List<WeatherInfoModel> weatherInfoModels = new ArrayList<>();

		String city = req.getParameter("city");

		if (StringUtils.isEmpty(city)) {
			logger.error(ConstantUtils.EMPTY_CITY_NAME);
			throw new EmptyCityNameException(ConstantUtils.EMPTY_CITY_NAME);

		} else {
			weatherInfoModels = weatherService.getWeatherInfoByCity(city);
			model.addAttribute("city", city);
			model.addAttribute("weatherInfoModels", weatherInfoModels);
		}
		logger.info("Weather data is updated for " + city);

		return "weather-data";

	}

	

	/*
	 * API to get weather data from external API using @PathVariable and send
	 * response in JSON format 
	 * 
	 * http://localhost:8080/weather-app/London
	 */@RequestMapping(value = "/{city}", method = RequestMethod.GET)
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

	

	/*
	* API to get weather data from external API using @RequestParam and send
	* response in JSON format 
	* 
	* http://localhost:8080/weather-app/city?name=London
	*/
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
