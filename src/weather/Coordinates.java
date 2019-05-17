package weather;

public class Coordinates {

    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height) {

        if (height > 100) {
            height = 100;
        } else if (height < 0) {
            height = 0;
        }
        if (latitude < 0) {
            latitude = 0;
        }
        if (longitude < 0) {
            longitude = 0;
        }

        this.height = height;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getLongitude() {
        return (this.longitude);
    }

    public int getLatitude() {
        return (this.latitude);
    }

    public int getHeight() {
        return (this.height);
    }

}
