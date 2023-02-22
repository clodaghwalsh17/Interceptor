package com.weatherStation.Interceptor;

public interface IWarningInterceptor extends Interceptor{
    void onWeatherWarning(WeatherWarning warning);
}
