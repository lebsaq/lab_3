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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(getClass() != obj.getClass()) return false;
        Human human = (Human) obj;
        return this.name.equals(human.name) && this.inventory.equals(human.inventory) && this.creatureType.equals(human.creatureType);
    }
}


