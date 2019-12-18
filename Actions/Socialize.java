package Actions;
import Actions.*;
import Creatures.*;
import Trash.*;
import Types.*;
public interface Socialize {
    public void sayExactMessage(Creature creature, String phrase);
    public void sayExactMessage(String phrase);
    public void sayExactMessage(Creature creature, int index);
    public void addMessage(String phrase);
}
