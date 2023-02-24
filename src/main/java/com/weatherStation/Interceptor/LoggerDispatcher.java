package com.weatherStation.Interceptor;

import java.util.ArrayList;
import java.util.List;

public class LoggerDispatcher implements Dispatcher, ILoggerInterceptor{
    private static LoggerDispatcher dispatcher;
    private List<Interceptor> interceptors;

    private LoggerDispatcher() {
        interceptors = new ArrayList<Interceptor>();
    }

    public static LoggerDispatcher getDispatcher() {
        if(dispatcher == null) {
            dispatcher = new LoggerDispatcher();
        }

        return dispatcher;
    }

    public void attach(Interceptor logger) {
        interceptors.add(logger);
    }

    public void detach(Interceptor logger) {
        interceptors.remove(logger);
    }

    public void onWeatherChange(WeatherInfo info) {
        for(Interceptor interceptor: interceptors) {
            LoggerInterceptor loggerInterceptor = (LoggerInterceptor) interceptor;
            loggerInterceptor.onWeatherChange(info);
        }
    }

}
