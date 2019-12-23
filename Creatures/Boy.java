package Creatures;

import Types.CreatureType;

public class Boy extends Human {
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
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}


