package com.weatherStation;

import com.weatherStation.Interceptor.WarningDispatcher;
import com.weatherStation.Interceptor.WeatherWarning;

public class ForecastDisplay implements Observer, DisplayElement {
	private float currentPressure = 29.92f;  
	private float lastPressure;
	private WeatherData weatherData;

	public ForecastDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void update(float temp, float humidity, float pressure) {
        lastPressure = currentPressure;
		currentPressure = pressure;
		display();
	}

	public void display() {
		System.out.print("Forecast: ");
		if (currentPressure > lastPressure) {
			String forecast = "Improving weather on the way!\n";
			System.out.printf(forecast);
		} else if (currentPressure == lastPressure) {
			String forecast = "More of the same\n";
			System.out.printf(forecast);
		} else if (currentPressure < lastPressure) {
			String forecast = "Watch out for cooler, rainy weather\n";
			System.out.printf(forecast);
			WeatherWarning warning = new WeatherWarning(forecast);
			WarningDispatcher.getDispatcher().onWeatherWarning(warning);
		}
	}
}
