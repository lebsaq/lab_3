package Creatures;

import Actions.*;
import Trash.*;
import Types.*;

import java.util.InputMismatchException;
import java.util.LinkedList;

public abstract class Creature implements Socialize, WatchPerformance {
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
        System.out.println(this.toString() + " думает: " + phrase);
    }

    @Override
    public void sayExactMessage(Creature creature, int index) {
        this.knowledge.add(this.knowledge.get(index));
        System.out.println(this.toString() +" говорит: " + this.knowledge.get(index));
    }

    public void sayExactMessage(Creature creature, String phrase){
        creature.knowledge.add(phrase);
        System.out.println(this.toString() +" говорит: " + phrase);
    }
    public void sayExactMessage(Creature creature, Performance performance){
        creature.knowledge.add(performance.toString());
        System.out.println(this.toString() +" говорит: " + performance.toString());
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
        System.out.println(this.toString() + ": выбегает на " + place);
    }
    public void watchPerformance(Performance performance) throws InputMismatchException{
        if(this.place.getType().equals(performance.getPlace().getType())){
            throw new InputMismatchException();
        }
        else{
            this.knowledge.add("I have watched performance!");
        }
    }
}
