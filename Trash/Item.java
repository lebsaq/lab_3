package Trash;

import Actions.*;
import Creatures.*;
import Trash.*;
import Types.*;
import Types.ItemType;

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
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Item temp = (Item) obj;
        return (this.getName().equals(temp.getName()))&&(this.amount == temp.amount);
    }



    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
