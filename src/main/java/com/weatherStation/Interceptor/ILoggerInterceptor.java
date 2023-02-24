package com.weatherStation.Interceptor;

public interface ILoggerInterceptor extends Interceptor{
    void onWeatherChange(WeatherInfo info);
}
