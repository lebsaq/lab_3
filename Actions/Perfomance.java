package Actions;
import Actions.*;
import Creatures.*;
import Trash.*;
import Types.*;

public class Perfomance{
    protected String name;
    protected Place place;

    public Perfomance(){
        this("unknown");
    }
    public Perfomance(String name){
        this.name = name;
    }
    public Perfomance(String name, Place place){
        this.name = name;
        this.place = place;
    }
    public void setPlace(Place place){
        this.place = place;
    }
    public Place getPlace(){
        return this.place;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
}
