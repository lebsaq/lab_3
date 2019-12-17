package Creatures;

import Types.CreatureType;

public class Girl extends Human {
    public Girl(){
        this("unknown");
    }
    public Girl(String name){
        super(name);
        this.creatureType = CreatureType.GIRL;
    }
}
