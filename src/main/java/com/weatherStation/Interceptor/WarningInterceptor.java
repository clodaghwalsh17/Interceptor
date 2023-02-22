package com.weatherStation.Interceptor;

import java.util.Date;

public class WarningInterceptor implements Interceptor {
    
    public void onWeatherWarning(WeatherWarning warning) {
        Date time = new Date();
        System.out.printf("Warning issued at %s. Details - %s\n", time.toString(), warning.getWarning());
    }

}
