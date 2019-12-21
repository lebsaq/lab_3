package Creatures;

import Actions.*;
import Creatures.*;
import Trash.*;
import Types.*;

import Types.CreatureType;
import Types.ItemType;
import Types.PlaceType;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;

public class Human extends Creature implements BuySweets, PresentKarlson {
    private List<Human> humans = new ArrayList<>();
    protected LinkedList<Item> inventory = new LinkedList<>();
    public Human(String name){
        super(name, CreatureType.HUMAN);
    }
    public  Human(String name, CreatureType type){
        super(name, type);
    }
    public Human(){
        this("unknown");
    }

    public void addBalance(int amountOfMoney) {
        {
            Item tempItem = new Item("ere", ItemType.MONEY);
            this.inventory.add(tempItem);
        }
        for(int i=0; i<this.inventory.size(); i++){
            if (this.inventory.get(i).getType() == ItemType.MONEY){
                this.inventory.get(i).addAmount(amountOfMoney);
                return;
            }
        }

    }

    public int getBalance() {
        int res = 0;
        for (Item item: this.inventory) {
            if(item.getType() != ItemType.MONEY) {
                continue;
            }
            res += item.getAmount();
        }
        System.out.println(this.name + " получил "+ res + " монет");
        return res;
    }

    @Override
    public void buySweets (Shop shop) throws InputMismatchException {
        int amountOfMoney = getBalance();
        if(!this.place.getType().equals(PlaceType.NEXTTOSHOP)){
            throw new InputMismatchException();
        }
        else {
            for (int i = 0; i < this.inventory.size(); i++) {
                if (this.inventory.get(i).getType() == ItemType.MONEY) {
                    if (this.inventory.get(i).getAmount() >= amountOfMoney) {
                        this.inventory.get(i).setAmount(-amountOfMoney);
                        shop.addBalance(amountOfMoney);
                        LinkedList<Item> tempList = shop.sellSweets(amountOfMoney);
                        System.out.println(this.toString() +" купил "+ tempList.size() +" конфет");
                        this.inventory.addAll(tempList);
                    } else {
                        throw new InputMismatchException();
                    }
                } else {
                    throw new InputMismatchException();
                }
            }
        }
    }
    public void presentKarlson(Human human, LinkedList<Item> list) throws  InputMismatchException{
        if(!human.creatureType.toString().equals(CreatureType.KARLSON.toString())){
            throw new InputMismatchException();
        }
        else if(!human.getPlace().getType().equals(this.getPlace().getType())){
            throw new InputMismatchException();
        }
        else{
            for(int i = 0; i < list.size(); i++){
                if(this.inventory.contains(list.get(i))) {
                    human.inventory.add(list.get(i));
                }
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        Human human = (Human) obj;
        return this.inventory.equals(human.inventory) && this.name.equals(human.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}
