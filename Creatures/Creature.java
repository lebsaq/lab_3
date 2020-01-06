package Creatures;
import Actions.*;
import Exceptions.NotaCreatureException;
import Trash.*;
import Types.*;
import java.util.*;

public abstract class Creature implements Socialize, WatchPerformance {
    public final int moneyIndex = 0;
    protected String name;
    protected List<Human> humans = new ArrayList<>();
    protected List<String> knowledge = new ArrayList<>();
    protected CreatureType creatureType;
    protected Place place;

    protected Creature(String name, CreatureType crType){
        this.name = name;
        this.creatureType = crType;
    }

    protected Creature(String name){
        this(name, CreatureType.UNKNOWN);
    }

    protected Creature(){
        this("unknown");
    }

    public Place getPlace(){
        return this.place;
    }

    public List<Human> getHumans() {
        return humans;
    }

    @Override
    public void addMessage(String phrase) {
        this.knowledge.add(phrase);
        System.out.println(this.toString() + " думает: " + phrase);
    }

    @Override
    public void sayExactMessage(Creature creature, int index) throws NotaCreatureException {
        if (creature == null) {
            throw new NotaCreatureException("Существо должно существовать");
        }
        this.knowledge.add(this.knowledge.get(index));
        System.out.println(this.toString() + " говорит: " + this.knowledge.get(index));
    }

    public void sayExactMessage(Creature creature, String phrase) throws NotaCreatureException {
        if (creature == null) {
            throw new NotaCreatureException("Существо должно существовать");
        }
        creature.knowledge.add(phrase);
        System.out.println(this.toString() + " говорит: " + phrase);
    }

    public void sayExactMessage(Creature creature, Performance performance) throws NotaCreatureException {
        if (creature == null) {
            throw new NotaCreatureException("Существо должно существовать");
        }
        creature.knowledge.add(performance.toString());
        System.out.println(this.toString() + " говорит: " + performance.toString());
    }

    public void sayExactMessage(String phrase) {
        this.knowledge.add(phrase);
        System.out.println(this.toString() + " говорит: " + phrase);
    }

    public String getExactMessage(int index) throws InputMismatchException {
        if (index > this.knowledge.size()) {
            throw new InputMismatchException();
        } else {
            return this.knowledge.get(index);
        }
    }

    public void addKnowledge(String phrase) {
        this.knowledge.add(phrase);
    }

    public void setPlace(Place place) {
        this.place = place;
        System.out.println(this.toString() + ": выбегает на " + place);
    }

    public void watchPerformance(Performance performance) throws InputMismatchException {
        if (this.place.getType().equals(performance.getPlace().getType())) {
            throw new InputMismatchException();
        } else {
            this.knowledge.add("I have watched performance!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return  Objects.equals(name, creature.name) &&
                Objects.equals(knowledge, creature.knowledge) &&
                creatureType == creature.creatureType &&
                Objects.equals(place, creature.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moneyIndex, name, knowledge, creatureType, place);
    }

}
