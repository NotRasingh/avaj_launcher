package aircraft;

import filehandling.WriteFile;
import simulator.Aircraft;
import simulator.WeatherTower;
import weather.Coordinates;

import java.io.IOException;
import java.util.Arrays;

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
            try {
                WriteFile data = new WriteFile("simulation.txt", true);
                data.writeToFile("Baloon#" + this.name + "(" + this.id + ")" +"B SUN");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (new_weather.equals("RAIN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                    coordinates.getHeight() - 5);
            try {
                WriteFile data = new WriteFile("simulation.txt", true);
                data.writeToFile("Baloon#" + this.name + "(" + this.id + ")" +"B RAIN");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (new_weather.equals("FOG")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                    coordinates.getHeight() - 3);
            try {
                WriteFile data = new WriteFile("simulation.txt", true);
                data.writeToFile("Baloon#" + this.name + "(" + this.id + ")" +"B FOG");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (new_weather.equals("SNOW")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                    coordinates.getHeight() - 15);
            try {
                WriteFile data = new WriteFile("simulation.txt", true);
                data.writeToFile("Baloon#" + this.name + "(" + this.id + ")" +"B SNOW");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        if (coordinates.getHeight() <= 0) {
            try {
                WriteFile data = new WriteFile("simulation.txt", true);
                data.writeToFile("Baloon#" + this.name + "(" + this.id + ")" + " landing.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            this.weatherTower.unregister(this);
            try {
                WriteFile data = new WriteFile("simulation.txt", true);
                data.writeToFile("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } }

    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        try {
            WriteFile data = new WriteFile("simulation.txt", true);
            data.writeToFile("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
       }
}

