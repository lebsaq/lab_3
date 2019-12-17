package Creatures;

import Types.CreatureType;

public class Boy extends Human {
    public Boy(String name){
        super(name);
        this.creatureType = CreatureType.BOY;
    }
}
