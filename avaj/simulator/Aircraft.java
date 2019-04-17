package avaj.simulator;

import avaj.weather.Coordinates;

public class Aircraft{

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private long idCounter;

    protected Aircraft(String name, Coordinates coordinates)
    {
        this.id = this.nextid();
        this.name = name;
        this.coordinates = coordinates;
    }

    public long nextid(){
        return (idCounter++);
    }
}