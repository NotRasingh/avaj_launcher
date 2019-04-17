package avaj.Aircrafts;

import avaj.simulator.Aircraft;
import avaj.simulator.WeatherTower;
import avaj.weather.Coordinates;

public class Helicopter extends Aircraft implements Flyable {

    WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String new_weather = weatherTower.getWeather(coordinates);

        if (new_weather.equals("SUN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(),
                    coordinates.getHeight() + 2);
            System.out.println("H SUN");
        } else if (new_weather.equals("RAIN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(),
                    coordinates.getHeight());
            System.out.println("H RAIN");
        } else if (new_weather.equals("FOG")) {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(),
                    coordinates.getHeight());
            System.out.println("H FOG");
        } else if (new_weather.equals("SNOW")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                    coordinates.getHeight() - 12);
            System.out.println("H SNOW");
        }

        if (coordinates.getHeight() <= 0) {
            System.out.println("Helicopter#" + this.name + "(" + this.id + ")" + " landing.");
            this.weatherTower.unregister(this);
            System.out.println(
                    "Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");

        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out
                .println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}