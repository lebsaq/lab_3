package Trash;

import Types.PlaceType;

import java.util.Objects;

public class Place {
    protected String name;
    protected PlaceType type;


    public Place(){
        this("unknown");
    }
    public Place(String name){
        this(name, PlaceType.NONE);
    }
    public Place(String name, PlaceType type){
        this.name = name;
        this.type = type;
    }
    public PlaceType getType() {
        return this.type;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public String getName() {
        return this.name;
    }

    @Override
    public String toString(){
        return this.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != this.getClass()){
            return  false;
        }
        Place temp = (Place)obj;
        return (this.getName().equals(temp.getName())) && (this.getType().equals(temp.getType()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
