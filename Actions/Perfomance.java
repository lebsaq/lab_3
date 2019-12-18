package Actions;
import Actions.*;
import Creatures.*;
import Trash.*;
import Types.*;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "Perfomance{" + "face=" + name + ", place=" + place + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        Perfomance temp = (Perfomance) obj;
        return Objects.equals(name, temp.name) &&
                Objects.equals(place, temp.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, place);
    }
}
