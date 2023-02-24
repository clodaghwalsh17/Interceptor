package com.weatherStation.Interceptor;

import java.util.ArrayList;
import java.util.List;

public class WarningDispatcher implements Dispatcher, IWarningInterceptor{
    private static WarningDispatcher dispatcher;
    private List<Interceptor> interceptors;

    private WarningDispatcher() {
        interceptors = new ArrayList<Interceptor>();
    }

    public static WarningDispatcher getDispatcher() {
        if(dispatcher == null) {
            dispatcher = new WarningDispatcher();
        }

        return dispatcher;
    }

    public void attach(Interceptor interceptor) {
        interceptors.add(interceptor);
    }

    public void detach(Interceptor interceptor) {
        interceptors.remove(interceptor);
    }

    public void onWeatherWarning(WeatherWarning warning) {
        for(Interceptor interceptor: interceptors) {
            WarningInterceptor warningInterceptor = (WarningInterceptor) interceptor;
            warningInterceptor.onWeatherWarning(warning);
        }        
    }
}
