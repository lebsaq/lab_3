package Creatures;

import Types.CreatureType;

import java.util.Objects;

public class Girl extends Human {
    public Girl(){
        this("unknown", CreatureType.UNKNOWN);
    }
    public Girl(String name){
        // TODO: super(name, CreatureType.GIRL);
        super(name, CreatureType.GIRL);
        this.knowledge.add("У МАЛЫША ТУСА");
    }

    public Girl(String name, CreatureType type){
        super(name,type);
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
