package com.arya.spring.service;

import java.util.List;

import com.arya.spring.model.WeatherInfoModel;

public interface WeatherService {
	
	List<WeatherInfoModel> getWeatherInfoByCity(String city);

}
