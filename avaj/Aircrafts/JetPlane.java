package avaj.Aircrafts;

import avaj.simulator.Aircraft;
import avaj.simulator.WeatherTower;
import avaj.weather.Coordinates;

public class JetPlane extends Aircraft implements Flyable {

    WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String new_weather = weatherTower.getWeather(coordinates);

        if (new_weather.equals("SUN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10,
                    coordinates.getHeight() + 2);
            System.out.println("J SUN");
        } else if (new_weather.equals("RAIN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5,
                    coordinates.getHeight());
            System.out.println("J RAIN");
        } else if (new_weather.equals("FOG")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1,
                    coordinates.getHeight());
            System.out.println("J FOG");
        } else if (new_weather.equals("SNOW")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                    coordinates.getHeight() - 7);
            System.out.println("J SNOW");
        }

        if (coordinates.getHeight() <= 0) {
            System.out.println("JetPlane#" + this.name + "(" + this.id + ")" + " landing.");
            this.weatherTower.unregister(this);
            System.out.println(
                    "Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");

        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out
                .println("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}