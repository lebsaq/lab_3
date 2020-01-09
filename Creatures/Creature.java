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

    protected CreatureType creatureType;
    protected Place place;
    protected Place livingPlace;

    protected Creature(String name, CreatureType crType){
        this.name = name;
        this.creatureType = crType;
        this.place=new Place("default", PlaceType.UNKNOWN);

    }

    protected Creature(String name){
        this(name, CreatureType.UNKNOWN);
        this.place=new Place("default", PlaceType.UNKNOWN);
    }

    protected Creature(String name, Place livingPlace){
        this.name=name;
        this.livingPlace=livingPlace;
        this.place=new Place("default", PlaceType.UNKNOWN);
    }

    protected Creature(){
        this("unknown");
        this.place=new Place("default", PlaceType.UNKNOWN);

    }

    public Place getPlace(){
        System.out.println(this + " находится на " + this.place);
        return this.place;
    }

    public List<Human> getHumans() {
        return humans;
    }

        protected LinkedList<String> knowledge = new LinkedList<>();

        @Override
        public void addMessage(String phrase) {
            this.knowledge.add(phrase);
            System.out.println(this.toString() + " думает " + phrase);
        }

        @Override
        public void sayExactMessage(Creature creature, int index) throws NotaCreatureException {
            if (creature == null) {
                throw new NotaCreatureException("Существо должно существовать");
            }
            this.knowledge.add(this.knowledge.get(index));
            System.out.println(this.toString() + " говорит " + this.knowledge.get(index));
        }

        public void sayExactMessage(Creature creature, String phrase) throws NotaCreatureException {
            if (creature == null) {
                throw new NotaCreatureException("Существо должно существовать");
            }
            this.knowledge.add(phrase);
            System.out.println(this.toString() + " говорит " + phrase);
        }

        public void sayExactMessage(Creature creature, Performance performance) throws NotaCreatureException {
            if (creature == null) {
                throw new NotaCreatureException("Существо должно существовать");
            }
            this.knowledge.add(performance.toString());
            System.out.println(this.toString() + " говорит " + performance.toString());
        }

        public void sayExactMessage(String phrase) {
            this.knowledge.add(phrase);
            System.out.println(this.toString() + " говорит " + phrase);
        }

        public void sayExactMessage(int index) {
            //this.knowledge.add();
            System.out.println(this.toString() + " говорит " + this.knowledge.get(index));
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
            System.out.println(this.knowledge.indexOf(phrase));
        }



    public void setPlace(Place place) throws InputMismatchException{
        this.place = place;
        System.out.println(this.toString() + " выбегает на " + place);
    }

    public void watchPerformance(Performance performance) throws InputMismatchException {
        if (!this.place.getType().equals(performance.getPlace().getType()) && this.place!=null) {
            throw new InputMismatchException();
        } else {
            this.sayExactMessage("\"I have watched performance " + performance.getName() + "\"!");
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
        return Objects.hash(name, knowledge, creatureType, place);
    }

}
