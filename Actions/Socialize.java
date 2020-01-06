package Actions;
import Actions.*;
import Creatures.*;
import Exceptions.NotaCreatureException;
import Trash.*;
import Types.*;
public interface Socialize {
    public void sayExactMessage(Creature creature, String phrase) throws NotaCreatureException;
    public void sayExactMessage(String phrase) throws NotaCreatureException;
    public void sayExactMessage(Creature creature, int index) throws NotaCreatureException;
    public void addMessage(String phrase);
}
