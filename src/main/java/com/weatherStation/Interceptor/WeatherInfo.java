package com.weatherStation.Interceptor;

import com.weatherStation.WeatherData;

public class WeatherInfo { 
    private WeatherData data;

    public WeatherInfo(WeatherData data) {
        this.data = data;
    }

    public float getTemperature() {
        return data.getTemperature();
    }
	
    public float getHumidity() {
        return data.getHumidity();
    }
	
    public float getPressure() {
        return data.getPressure();
    }

}
