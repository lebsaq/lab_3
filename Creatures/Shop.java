package Creatures;

import Trash.Item;
import Types.ItemType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Shop {
    private LinkedList<Item> inventory = new LinkedList<>();
    private int balance;

    public int getBalance() {
        return this.balance;
    }

    public void addSweets(int amount) {
        inventory.add(new Item("sweet", ItemType.SWEET, amount));
    }

    public void setBalance(int newBalance) {
        this.balance = newBalance;
    }

    public void addBalance(int amount) {
        this.balance += amount;
    }

    public ArrayList<Item> sellSweets(int amountOfMoney) {
        ArrayList<Item> tempList = new ArrayList<>();
        if (amountOfMoney > 0) {
            this.addBalance(amountOfMoney);
            tempList.add(new Item("sweet", ItemType.SWEET, amountOfMoney));
            amountOfMoney=0;
            }
        return tempList;
    }

    @Override
    public String toString() {
        return "Shop{" + "inventory=" + inventory.size() + ", balance=" + balance + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return balance == shop.balance && Objects.equals(inventory, shop.inventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventory, balance);
    }



}

//
// if (this.inventory.getLast().getAmount()<= amountOfMoney) {
//         tempList.add(this.inventory.get(moneyIndex));
//         amountOfMoney = amountOfMoney - this.inventory.getLast().getAmount();
//         this.inventory.remove(this.inventory.get(moneyIndex));
//         } else {
//         Item tempItem = new Item(this.inventory.get(moneyIndex).getName(), this.inventory.get(moneyIndex).getType(), this.inventory.get(moneyIndex).getAmount() - amountOfMoney);
//         tempList.add(tempItem);
//         this.inventory.get(moneyIndex).addAmount(-amountOfMoney);
//         }