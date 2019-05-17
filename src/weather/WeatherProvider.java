package weather;

public class WeatherProvider{

    private String[] weather;
    static private WeatherProvider weatherProvider = new WeatherProvider() ;

    private WeatherProvider(){
        weather = new String[] {"RAIN", "FOG", "SUN", "SNOW"};
       }


    public static WeatherProvider getProvider(){
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        int sum = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
        return (weather[sum % 4]);
    }
}