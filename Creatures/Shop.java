package Creatures;

import Trash.Item;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class Shop extends Creature {
    private LinkedList<Item> inventory = new LinkedList<>();
    private int balance;

    public int getBalance() {
        return this.balance;
    }
    public void setBalance(int newBalance){
        this.balance = newBalance;
    }
    public void addBalance(int amount){
        this.balance += amount;
    }
    public LinkedList<Item> sellSweets(int amountOfMoney){
        this.addBalance(amountOfMoney);
        LinkedList<Item> tempList = new LinkedList<>();
        int temp = amountOfMoney;
        while(temp > 0){
            if(this.inventory.getLast().amount<=temp){
                tempList.add(this.inventory.getLast());
                temp = temp - this.inventory.getLast().amount;
                this.inventory.remove(this.inventory.getLast());
            }
            else{
                Item tempItem = new Item(this.inventory.getLast().getName(), this.inventory.getLast().getType(), this.inventory.getLast().getAmount()-amountOfMoney);
                tempList.add(tempItem);
                this.inventory.getLast().addAmount(-amountOfMoney);
            }
        }
        return tempList;
    }
}
