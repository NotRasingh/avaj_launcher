package aircraft;

import filehandling.WriteFile;
import simulator.Aircraft;
import simulator.WeatherTower;
import weather.Coordinates;

import java.io.IOException;

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
            try {
                WriteFile data = new WriteFile("simulation.txt", true);
                data.writeToFile("JetPlane#" + this.name + "(" + this.id + ")" +"J SUN");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
         } else if (new_weather.equals("RAIN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5,
                    coordinates.getHeight());
            try {
                WriteFile data = new WriteFile("simulation.txt", true);
                data.writeToFile("JetPlane#" + this.name + "(" + this.id + ")" +"J RAIN");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (new_weather.equals("FOG")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1,
                    coordinates.getHeight());
            try {
                WriteFile data = new WriteFile("simulation.txt", true);
                data.writeToFile("JetPlane#" + this.name + "(" + this.id + ")" +"J FOG");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (new_weather.equals("SNOW")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                    coordinates.getHeight() - 7);
            try {
                WriteFile data = new WriteFile("simulation.txt", true);
                data.writeToFile("JetPlane#" + this.name + "(" + this.id + ")" +"J SNOW");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        if (coordinates.getHeight() <= 0) {
            try {
                WriteFile data = new WriteFile("simulation.txt", true);
                data.writeToFile("JetPlane#" + this.name + "(" + this.id + ")" + " landing.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            this.weatherTower.unregister(this);
            try {
                WriteFile data = new WriteFile("simulation.txt", true);
                data.writeToFile("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        try {
            WriteFile data = new WriteFile("simulation.txt", true);
            data.writeToFile("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}