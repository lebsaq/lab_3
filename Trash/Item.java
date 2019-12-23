package Trash;

import Actions.*;
import Creatures.*;
import Trash.*;
import Types.*;
import Types.ItemType;

import java.util.Objects;

public class Item {
    protected String name;
    protected ItemType type;
    protected int amount;

    public Item(String name, ItemType type, int amount){
        this.name = name;
        this.type = type;
        this.amount = amount;
    }

    public Item(String name, ItemType type) {
        this(name, type, 0);
    }

    public Item(String name) {
        this(name, ItemType.NONE);
    }

    public Item() {
        this("unknown", ItemType.NONE);
    }

    public String getName() {
        return this.name;
    }

    public ItemType getType() {
        return this.type;
    }
    public int getAmount(){
        return this.amount;
    }
    public void addAmount(int amount){
        this.amount += amount;
    }
    public void setAmount(int newAmount){
        this.amount = newAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return amount == item.amount &&
                Objects.equals(name, item.name) &&
                type == item.type;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount, type);
    }
}
