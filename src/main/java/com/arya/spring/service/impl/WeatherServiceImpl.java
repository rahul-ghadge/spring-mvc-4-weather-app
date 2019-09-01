package com.arya.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.arya.spring.model.WeatherInfoModel;
import com.arya.spring.service.WeatherService;
import com.arya.spring.utils.ConstantUtils;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Override
	public List<WeatherInfoModel> getWeatherInfoByCity(String cityNames) {

		List<WeatherInfoModel> weatherInfoModels = new ArrayList<>();
		RestTemplate restTemplate = new RestTemplate();
		
		String[] cityArray = cityNames.split(",");

		
		for (String city : cityArray) {
			
			if (!StringUtils.isEmpty(city)) {
				
				WeatherInfoModel weatherInfoModel = new WeatherInfoModel();
				String weatherUrlForCity = String.format(ConstantUtils.WEATHER_API, city.trim());
				weatherInfoModel = restTemplate.getForObject(weatherUrlForCity, WeatherInfoModel.class);

				weatherInfoModels.add(weatherInfoModel);
			}
		}

		return weatherInfoModels;
	}

}
