package Creatures;

import Actions.*;
import Creatures.*;
import Trash.*;
import Types.*;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.LinkedList;

public abstract class Creature implements Socialize, WatchPerfomance {
    protected String name;
    protected LinkedList<String> knowledge = new LinkedList<>();
    protected CreatureType creatureType;
    protected Place place;

    protected Creature(String name,CreatureType crType){
        this.name = name;
        this.creatureType=crType;
    }
    protected Creature (String name){
        this(name, CreatureType.NONE);
    }
    protected Creature (){
        this("unknown");
    }

    public Place getPlace(){
        return this.place;
    }

    @Override
    public void addMessage(String phrase){
        this.knowledge.add(phrase);
        System.out.println("thinking");
    }

    @Override
    public void sayExactMessage(Creature creature, int index) {

    }

    public void sayExactMessage(Creature creature, String phrase){
            creature.knowledge.add(phrase);
        System.out.println(phrase);
    }
    public void sayExactMessage(String phrase){
        this.knowledge.add(phrase);
        System.out.println(phrase);
    }

    public String getExactMessage(int index) throws InputMismatchException {
        if(index > this.knowledge.size()){
            throw new InputMismatchException();
        }
        else{
            return this.knowledge.get(index);
        }
    }
    public void addKnowledge(String phrase){
        this.knowledge.add(phrase);
    }
    public void setPlace(Place place){
        this.place = place;
    }
    public void watchPerfomance(Perfomance perfomance) throws InputMismatchException{
        if(this.place.getType().equals(perfomance.getPlace().getType())){
            throw new InputMismatchException();
        }
        else{
            this.knowledge.add("I have watched perfomane!");
        }
    }
}
