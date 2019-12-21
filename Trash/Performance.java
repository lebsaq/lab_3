package Trash;

import java.util.Objects;

public class Performance{
    protected String name;
    protected Place place;

    public Performance(){
        this("unknown");
    }
    public String getInfo(){
        return this.name + " в " + this.place;
    }
    public Performance(String name){
        this.name = name;
    }
    public Performance(String name, Place place){
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
        return "Performance: " + "name = " + name + ", place = " + place;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        Performance temp = (Performance) obj;
        return Objects.equals(name, temp.name) &&
                Objects.equals(place, temp.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, place);
    }
}
