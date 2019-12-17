package Creatures;

import Actions.*;
import Creatures.*;
import Trash.*;
import Types.*;

import Types.CreatureType;
import Types.ItemType;
import Types.PlaceType;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Objects;

public class Human extends Creature implements BuySweets, PresentKarlson {
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


    public void addBalance(int amountOfMoney){
        for(int i=0;i<this.inventory.size();i++){
            if (this.inventory.get(i).getType()== ItemType.MONEY){
                this.inventory.get(i).addAmount(amountOfMoney);
                return;
            }
        }
        {
            Item tempItem = new Item("ere", ItemType.MONEY);
            this.inventory.add(tempItem);
        }
    }

    @Override
    public void buySweets (Shop shop, int amountOfMoney) throws InputMismatchException {
        if(!this.place.getName().equals(PlaceType.NEXTTOSHOP.toString())){
            throw new InputMismatchException();
        }
        else {
            Item temp = new Item("temp", ItemType.MONEY, amountOfMoney);
            for (int i = 0; i < this.inventory.size(); i++) {
                if (this.inventory.get(i).getType() == ItemType.MONEY) {
                    if (this.inventory.get(i).getAmount() >= amountOfMoney) {
                        this.inventory.get(i).setAmount(-amountOfMoney);
                        //shop.addBalance(amountOfMoney);
                        LinkedList<Item> tempList = shop.sellSweets(amountOfMoney);
                        for (int j = 0; j < tempList.size(); j++) {
                            this.inventory.add(tempList.get(j));
                        }
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(inventory, human.inventory) && this.name.equals(human.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
