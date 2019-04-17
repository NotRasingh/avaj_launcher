package avaj.Aircrafts;

import avaj.simulator.Aircraft;
import avaj.simulator.WeatherTower;
import avaj.weather.Coordinates;

public class Baloon extends Aircraft implements Flyable {

    WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String new_weather = weatherTower.getWeather(coordinates);

        if (new_weather.equals("SUN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(),
                    coordinates.getHeight() + 4);
            System.out.println("B SUN");
        } else if (new_weather.equals("RAIN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                    coordinates.getHeight() - 5);
            System.out.println("B RAIN");
        } else if (new_weather.equals("FOG")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                    coordinates.getHeight() - 3);
            System.out.println("B FOG");
        } else if (new_weather.equals("SNOW")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                    coordinates.getHeight() - 15);
            System.out.println("B SNOW");
        }

        if (coordinates.getHeight() <= 0) {
            System.out.println("Baloon#" + this.name + "(" + this.id + ")" + " landing.");
            this.weatherTower.unregister(this);
            System.out.println(
                    "Tower says: Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");

        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out
                .println("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}