package Creatures;

import Trash.Item;
import Types.ItemType;

import java.util.LinkedList;
import java.util.Objects;

public class Shop extends Creature {
    private LinkedList<Item> inventory = new LinkedList<>();
    private int balance;

    public int getBalance() {
        return this.balance;
    }

    public void addSweets(int amount){
        inventory.add(new Item("sweet", ItemType.SWEET,amount));
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
            if(this.inventory.getLast().getAmount()<=temp){
                tempList.add(this.inventory.getLast());
                temp = temp - this.inventory.getLast().getAmount();
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

    @Override
    public String toString() {
        return "Shop{" + "inventory=" + inventory.size() + ", balance=" + balance + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        Shop shop = (Shop) obj;
        return balance == shop.balance && Objects.equals(inventory, shop.inventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventory, balance);
    }
}
