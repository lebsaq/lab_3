package Creatures;

import Trash.Item;
import Types.CreatureType;
import Types.ItemType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class They extends Creature {
    private List<Human> humans = new ArrayList<>();
    private LinkedList<Item> inventory = new LinkedList<>();

    public They(){
        this("unknown");
    }

    public They(String name){
        super(name, CreatureType.OTHER);
    }

    public They (int n,String name) {
        super(name, CreatureType.OTHER);
        for (int i = 0; i < n; i++) {
            Human human = new Human("John Doe", CreatureType.HUMAN);
            human.addBalance(i);
           // System.out.println(human.getBalance());
            humans.add(human);
        }
    }
    public List<Human> getHumans(){
        return humans;
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
