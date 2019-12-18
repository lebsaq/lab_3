package Creatures;

import Trash.Item;
import Types.CreatureType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class They extends Creature {
    public They(String name){
        super(name, CreatureType.OTHER);
    }
    public They(){
        this("unknown");
    }

    public List<Human> getHumans() {
        return humans;
    }

    public void setHumans(List<Human> humans) {
        this.humans = humans;
    }

    private List<Human> humans = new ArrayList<>();
    public They(int n){
        for (int i = 0; i < n; i++) {
            Human human = new Human("John Doe", CreatureType.HUMAN);
            human.addBalance(i);
            humans.add(human);
        }
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        They they = (They) obj;
        return this.name.equals(they.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }


}
