package avaj.simulator;

import avaj.weather.Coordinates;
import avaj.weather.WeatherProvider;
import avaj.simulator.Tower;

public class WeatherTower extends Tower{

    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather(){
        conditionsChanged();
    }
} 

