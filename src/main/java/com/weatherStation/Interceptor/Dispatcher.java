package com.weatherStation.Interceptor;

public interface Dispatcher {
    public void attach(Interceptor interceptor);
    public void detach(Interceptor interceptor);
}
