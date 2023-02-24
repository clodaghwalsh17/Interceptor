package test.java.com.weatherStation;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.weatherStation.HeatIndexDisplay;
import com.weatherStation.WeatherData;
import com.weatherStation.Interceptor.LoggerDispatcher;
import com.weatherStation.Interceptor.LoggerInterceptor;
import com.weatherStation.Interceptor.WarningDispatcher;
import com.weatherStation.Interceptor.WarningInterceptor;

public class TestHeatIndexWarning {
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
    public void testHeatIndexWarning() {
		HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
		weatherData.setMeasurements(100, 90, 29.2f);
        String time = new Date().toString();
        String logOutput = String.format("As at %s the weather conditions are as follows.\nTemperature:100.000000\nHumidity:90.000000\nPressure:29.200001\n", time);
        logOutput += String.format("Heat index is 167.789810\nWarning issued at %s. Details - Excessive Heat. Stay Indoors", time);
        assertEquals(logOutput, outputStreamCaptor.toString().trim());
    }
}
