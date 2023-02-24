package com.weatherStation;

import com.weatherStation.Interceptor.LoggerDispatcher;
import com.weatherStation.Interceptor.LoggerInterceptor;
import com.weatherStation.Interceptor.WarningDispatcher;
import com.weatherStation.Interceptor.WarningInterceptor;

public class WeatherStation {

	public static void main(String[] args) {
		LoggerInterceptor loggerInterceptor = new LoggerInterceptor();
		WarningInterceptor warningInterceptor = new WarningInterceptor();
		LoggerDispatcher.getDispatcher().attach(loggerInterceptor);
		WarningDispatcher.getDispatcher().attach(warningInterceptor);

		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(100, 90, 29.2f);
	}
}
