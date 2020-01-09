package Exceptions;
import Creatures.Creature;
public class NoEnoughMoneyException extends RuntimeException {

    public Creature getTarget() {
        return target;
    }
    private Creature target;

    public NoEnoughMoneyException (String messg, Creature target) {
        super(messg);
        this.target = target;
    }
}
