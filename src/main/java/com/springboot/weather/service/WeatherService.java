package com.springboot.weather.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
	
	private final static String baseURL = "https://api.open-meteo.com/v1/forecast";

	public String getCurrentTemperature(String latitude, String longitude) {

		String currentTemperature = "N/A";
		boolean isValid = validateInput(latitude, longitude);

		if (!isValid) { // invalid data input
			return currentTemperature;
		}
		String queryParam = "?latitude=" + latitude + "&longitude=" + longitude + "&current=temperature_2m";
		String uri = baseURL + queryParam;
		// String
		// uri="https://api.open-meteo.com/v1/forecast?latitude=45.2773&longitude=-75.8803&current=temperature_2m";
		String data = "";
		try {
			RestTemplate restTemplate = new RestTemplate();
			data = restTemplate.getForObject(uri, String.class);
			// extracting the last value of the data
			// sample data partially at the end
			// "current":{"time":"2025-01-19T15:45","interval":900,"temperature_2m":-13.1}}
			int lastIndex = data.lastIndexOf(":");
			currentTemperature = data.substring(lastIndex + 1, (data.length() - 2));

		} catch (Exception ex) {
			//System.out.println(ex.getMessage());
		}
		
		return currentTemperature;

	}

	// validate latitude and longitude
	private boolean validateInput(String latitude, String longitude) {

		String coordinateString = (latitude + "," + longitude);
		try {
			String[] parts = coordinateString.split(",");
			if (parts.length != 2) {
				return false;
			}

			double latitude1 = Double.parseDouble(parts[0].trim());
			double longitude1 = Double.parseDouble(parts[1].trim());
			if (latitude1 < -90 || latitude1 > 90 || longitude1 < -180 || longitude1 > 180) {
				return false;
			}

			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
