package Creatures;

import Trash.Item;
import Types.CreatureType;
import Types.ItemType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        They they = (They) o;
        return Objects.equals(humans, they.humans) &&
                Objects.equals(inventory, they.inventory);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }


}
