package com.weatherStation;

import com.weatherStation.Interceptor.LoggerDispatcher;
import com.weatherStation.Interceptor.LoggerInterceptor;

public class WeatherStation {

	public static void main(String[] args) {
		LoggerInterceptor interceptor = new LoggerInterceptor();
		LoggerDispatcher dispatcher = LoggerDispatcher.getDispatcher();
		dispatcher.attach(interceptor);

		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}
}
