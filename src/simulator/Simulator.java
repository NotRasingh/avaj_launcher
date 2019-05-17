package simulator;

import filehandling.ReadFile;
import weather.WeatherProvider;
import java.io.*;

public class Simulator {

    static int i;
    static int numSim;
    static WeatherTower weatherTower = new WeatherTower();
    public static void main(String[] args) {
        String file_name = "scenario";
          try {
            ReadFile file = new ReadFile(file_name);
            String[] aryLines = file.OpenFile();
            numSim = Integer.parseInt(aryLines[0]);
            for (i = 1; i < aryLines.length; i++) {
                String[] sLine = aryLines[i].split(" ");
                if (sLine[0].equalsIgnoreCase("Baloon") || sLine[0].equalsIgnoreCase("JetPlane")
                        || sLine[0].equalsIgnoreCase("Helicopter")) {
                    AircraftFactory.newAircraft(sLine[0], sLine[1], Integer.parseInt(sLine[2]),
                            Integer.parseInt(sLine[3]), Integer.parseInt(sLine[4])).registerTower(weatherTower);
                }
                /*
                 * System.out.println(Arrays.toString( sLine)); System.exit(0);
                 */
            }
             //   WeatherProvider weatherProvider = WeatherProvider.getProvider();
                 for (i = 1; i <= numSim; i++) {
                   weatherTower.changeWeather();
                }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
