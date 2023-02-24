package test.java.com.weatherStation;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.weatherStation.WeatherData;
import com.weatherStation.Interceptor.LoggerDispatcher;
import com.weatherStation.Interceptor.LoggerInterceptor;
import com.weatherStation.Interceptor.WarningDispatcher;
import com.weatherStation.Interceptor.WarningInterceptor;

public class TestInterceptor {
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
    public void testLoggerInterceptor() {
        weatherData.setMeasurements(80, 65, 30.4f);
		String logOutput = String.format("As at %s the weather conditions are as follows.\nTemperature:80.000000\nHumidity:65.000000\nPressure:30.400000", new Date().toString());
        assertEquals(logOutput, outputStreamCaptor.toString().trim());
    }
}
