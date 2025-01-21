package com.springboot.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.weather.service.WeatherService;

/**
 * 
 * @author tharm 
 * Description: The purpose is the get the current temperature of
 *         any region You need latitude and longitude of the location you are
 *         interested. The service is call from external API
 * 
 */

@RestController
public class WeatherController {

	@Autowired private 	WeatherService weatherService;

	@RequestMapping("/aboutus")
	public String sayHello() {
		return "Welcome to weather information site";
	}

	@GetMapping("/weather")
	@ResponseBody String  getCurrentTemperature(@RequestParam String latitude, @RequestParam String longitude) {
		String currentTemperature="N/A" ; 
		try {
			currentTemperature =  weatherService.getCurrentTemperature(latitude, longitude);
		   }catch(Exception ex) {
			   
		   }
		String finalResult = "{currentTemperature:" + currentTemperature + "}";
          return finalResult;
	}

}
