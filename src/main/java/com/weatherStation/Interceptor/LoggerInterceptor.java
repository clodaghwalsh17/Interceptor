package com.weatherStation.Interceptor;

import java.util.Date;

public class LoggerInterceptor implements ILoggerInterceptor{

    public void onWeatherChange(WeatherInfo info) {
        Date time = new Date();
        System.out.printf("As at %s the weather conditions are as follows.\nTemperature:%f\nHumidity:%f\nPressure:%f\n", time.toString(), info.getTemperature(), info.getHumidity(), info.getPressure());
    }
       
}
