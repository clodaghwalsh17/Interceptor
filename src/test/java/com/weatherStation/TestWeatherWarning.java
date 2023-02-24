package test.java.com.weatherStation;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.weatherStation.ForecastDisplay;
import com.weatherStation.WeatherData;
import com.weatherStation.Interceptor.LoggerDispatcher;
import com.weatherStation.Interceptor.LoggerInterceptor;
import com.weatherStation.Interceptor.WarningDispatcher;
import com.weatherStation.Interceptor.WarningInterceptor;

public class TestWeatherWarning {
    private WeatherData weatherData;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    
    @Before
    public void setUp(){
        LoggerInterceptor loggerInterceptor = new LoggerInterceptor();
		WarningInterceptor warningInterceptor = new WarningInterceptor();
		LoggerDispatcher.getDispatcher().attach(loggerInterceptor);
		WarningDispatcher.getDispatcher().attach(warningInterceptor);
        weatherData = new WeatherData();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testWeatherWarning() {
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		weatherData.setMeasurements(82, 70, 29.2f);
        String time = new Date().toString();
        String logOutput = String.format("As at %s the weather conditions are as follows.\nTemperature:82.000000\nHumidity:70.000000\nPressure:29.200001\n", time);
        logOutput += String.format("Forecast: Watch out for cooler, rainy weather\nWarning issued at %s. Details - Watch out for cooler, rainy weather", time);
        assertEquals(logOutput, outputStreamCaptor.toString().trim());
    }
}
