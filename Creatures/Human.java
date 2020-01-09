package Creatures;
import Actions.*;
import Exceptions.*;
import Trash.*;
import Types.*;

import java.util.*;


public class Human extends Creature implements BuySweets, PresentKarlson {
    public LinkedList<Item> inventory = new LinkedList<>();

    public Human(String name){
        super(name, CreatureType.HUMAN);
    }

    public Human(String name, CreatureType type){
        super(name, type);
    }
    public Human(){
        this("unknown");
    }


    public Human (String name, Place livingPlace){
        super(name,livingPlace);
    }

    public void setLivingPlace(Place livingPlace){
        this.livingPlace=livingPlace;
        System.out.println("Теперь " + name + " живёт на " + livingPlace);
    }

    public void addBalance(int amountOfMoney) {
        Item tempItem = new Item("ere", ItemType.MONEY);
        this.inventory.add(moneyIndex,tempItem);
        if (this.inventory.get(moneyIndex).getType() == ItemType.MONEY) {
            this.inventory.get(moneyIndex).addAmount(amountOfMoney+1);
        }
        System.out.println(this.name + " получил " + this.getBalance() + " монет");
    }

    public int getBalance() {
        int res = 0;
        for (Item item: this.inventory) {
            if(item.getType() != ItemType.MONEY) {
                continue;
            }
            res += item.getAmount();
        }
        return res;
    }

    @Override
    public void buySweets (Shop shop) throws NoEnoughMoneyException {
        int amountOfMoney = getBalance();
        if(!this.place.getType().equals(PlaceType.NEXTTOSHOP)){
            throw new InputMismatchException();
        }
        else {
            for (int i = 0; i < this.inventory.size(); i++) {
                if (this.inventory.get(i).getType().equals(ItemType.MONEY)) {
                    if (this.inventory.get(i).getAmount() >= amountOfMoney) {
                        this.inventory.get(i).addAmount(-amountOfMoney);
                        ArrayList<Item> tempList = shop.sellSweets(amountOfMoney);
                        this.inventory.addAll(tempList);
                        System.out.println(this.toString() + " купил " + this.inventory.getLast().getAmount() + " конфет");
                    } else {
                        throw new NoEnoughMoneyException("а денег то нет", this);
                    }
                    } else {
                    if (this.getBalance()>0) {
                        System.out.println("У парня осталось " + this.getBalance() + " денек");
                    } else{
                        System.out.println("У парня не осталось денек");
                    }
                }
            }
        }
    }

    public void presentKarlson(Human human, LinkedList<Item> list) throws InputMismatchException{
        if(!human.creatureType.toString().equals(CreatureType.KARLSON.toString())){
            throw new InputMismatchException();
        }
        else if(!human.getPlace().getType().equals(this.getPlace().getType())){
            throw new InputMismatchException();
        }
        else{
            for (Item item : list) {
                if (this.inventory.contains(item)) {
                    human.inventory.add(item);
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(name, human.name) &&
                Objects.equals(inventory, human.inventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, inventory);
    }

    @Override
    public String toString() {
        return name;
    }
}
