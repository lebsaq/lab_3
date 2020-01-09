package Creatures;

import Trash.Item;
import Types.*;
import java.util.*;

public class They extends Creature {

    private List<Item> inventory = new ArrayList<>();

    public They() {
        this("unknown");
    }

    public They(String name) {
        super(name, CreatureType.OTHER);
    }

    public static class Crowd extends Creature {
        private Object inventory;

        public Crowd(int n, String name) {
            super(name, CreatureType.OTHER);
            for (int i = 0; i < n; i += 2) {
                // TODO: https://ru.wikipedia.org/wiki/Принцип_подстановки_Барбары_Лисков
                Human human = new Human(String.format("John Doe_%s", i+1), CreatureType.OTHER);
                human.addBalance(i);
                humans.add(human);
            }
        }


        @Override
        public String toString() {
            return this.name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            They.Crowd they = (They.Crowd) o;
            return Objects.equals(humans, they.humans) &&
                    Objects.equals(inventory, they.inventory);
        }

        @Override
        public int hashCode() {
            return Objects.hash(humans, inventory);
        }
    }
}
