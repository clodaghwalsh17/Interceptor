package com.weatherStation.Interceptor;

import java.util.ArrayList;
import java.util.List;

public class LoggerDispatcher implements ILoggerInterceptor{
    private static LoggerDispatcher dispatcher;
    private List<LoggerInterceptor> interceptors;

    private LoggerDispatcher() {
        interceptors = new ArrayList<LoggerInterceptor>();
    }

    public static LoggerDispatcher getDispatcher() {
        if(dispatcher == null) {
            dispatcher = new LoggerDispatcher();
        }

        return dispatcher;
    }

    public void attach(LoggerInterceptor logger) {
        interceptors.add(logger);
    }

    public void detach(LoggerInterceptor logger) {
        interceptors.remove(logger);
    }

    public void onWeatherChange(WeatherInfo info) {
        for(LoggerInterceptor interceptor: interceptors) {
            interceptor.onWeatherChange(info);
        }
    }

    public void onWeatherWarning() {
        // TODO Auto-generated method stub
        
    }
}
