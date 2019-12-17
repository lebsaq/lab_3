package Creatures;

import Types.CreatureType;

public class They extends Creature {
    public They(String name){
        super(name, CreatureType.OTHER);
    }
    public They(){
        this("unknown");
    }
}
