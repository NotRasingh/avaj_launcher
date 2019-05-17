package aircraft;

import filehandling.WriteFile;
import simulator.Aircraft;
import simulator.WeatherTower;
import weather.Coordinates;

import java.io.IOException;

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
            try {
                WriteFile data = new WriteFile("simulation.txt", true);
                data.writeToFile("Helicopter#" + this.name + "(" + this.id + ")" + "H SUN");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (new_weather.equals("RAIN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(),
                    coordinates.getHeight());
            try {
                WriteFile data = new WriteFile("simulation.txt", true);
                data.writeToFile("Helicopter#" + this.name + "(" + this.id + ")" + "H RAIN");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (new_weather.equals("FOG")) {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(),
                    coordinates.getHeight());
            try {
                WriteFile data = new WriteFile("simulation.txt", true);
                data.writeToFile("Helicopter#" + this.name + "(" + this.id + ")" + "H FOG");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (new_weather.equals("SNOW")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                    coordinates.getHeight() - 12);
            try {
                WriteFile data = new WriteFile("simulation.txt", true);
                data.writeToFile("Helicopter#" + this.name + "(" + this.id + ")" + "H SNOW");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        if (coordinates.getHeight() <= 0) {
            try {
                WriteFile data = new WriteFile("simulation.txt", true);
                data.writeToFile("Helicopter#" + this.name + "(" + this.id + ")" + " landing.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            this.weatherTower.unregister(this);
            try {
                WriteFile data = new WriteFile("simulation.txt", true);
                data.writeToFile("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        try {
            WriteFile data = new WriteFile("simulation.txt", true);
            data.writeToFile("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}