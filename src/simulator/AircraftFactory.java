package simulator;

import aircraft.Baloon;
import aircraft.Flyable;
import aircraft.Helicopter;
import aircraft.JetPlane;
import weather.Coordinates;

public class AircraftFactory{

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height){

        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        if (type.toLowerCase().equals("jetplane"))
        {
            return new JetPlane(name, coordinates);
        }
        else if (type.toLowerCase().equals("baloon"))
        {
            return new Baloon(name, coordinates);
        }
        else if (type.toLowerCase().equals("helicopter"))
        {
            return new Helicopter(name, coordinates);
        }
        return null;
    }


}
