package avaj.simulator;

import avaj.Aircrafts.Baloon;
import avaj.Aircrafts.Flyable;
import avaj.Aircrafts.Helicopter;
import avaj.Aircrafts.JetPlane;
import avaj.weather.Coordinates;

public class AircraftFactory{

public Flyable newAircraft(String type, String name, int longitude, int latitude, int height){

    Coordinates coordinates = new Coordinates(longitude, latitude, height);

    if (type.toLowerCase().equals("jetplane"))
    {
        return new JetPlane(name, coordinates);
    }
    else if (type.toLowerCase().equals("baloon"))
    { 
        return new Baloon(name, coordinates);
    }
    else if (type.toLowerCase().equals("height"))
    {
        return new Helicopter(name, coordinates);
    }
    return null;
}


}