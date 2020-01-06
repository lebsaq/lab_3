package Creatures;

import Types.CreatureType;

import java.util.Objects;

public class Boy extends Human {
    public Boy(){
        this("unknown", CreatureType.UNKNOWN);
    }
    public Boy (String name, CreatureType type){
        super(name,type);
    }
    public Boy(String name){
        super(name);
        this.creatureType = CreatureType.BOY;
    }
    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, inventory);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}


