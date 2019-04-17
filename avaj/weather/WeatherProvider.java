package avaj.weather;

import avaj.weather.Coordinates;

public class WeatherProvider{

    private String[] weather;
    static private WeatherProvider weatherProvider;

    private WeatherProvider(){
        weather = new String[] {"RAIN", "FOG", "SUN", "SNOW"};
        weatherProvider = new WeatherProvider();
    }

    
    public static WeatherProvider getProvider(){
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
       int sum = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getHeight();
        return (weather[sum % 4]);
    }
}