import Creatures.*;
import Exceptions.NotaCreatureException;
import Trash.*;
import Types.*;

import java.util.*;

public class Main {

    public static void main(String[] args) throws NotaCreatureException {

        /**
       * Итак, они решили, что все конфеты получит Карлсон, который живет на крыше.
       * Кристер и Гунилла выбежали на улицу и рассказали всем детям, что наверху у Малыша сейчас
       * начнется большое представление "Вечер чудес".
       * И все, у кого было хотя бы пять эре, побежали в лавку и купили там "входные конфеты".
        */


        Place street = new Place("Street", PlaceType.STREET);
        Place nexttoshop = new Place("Shop", PlaceType.NEXTTOSHOP);
        They.Crowd they = new They.Crowd(10, "Они");
        they.setPlace(street);
        Roof roof = new Roof ("Крыша", PlaceType.ROOF);
        Human Karlson = new Human("Карлсон");
        Karlson.setLivingPlace(roof);
        Shop magaz = new Shop();
        Human krister = new Human("Федя", CreatureType.BOY);
        Human gunilla = new Human ("Катька",CreatureType.GIRL);
        magaz.addSweets(99999);
        Place youngBoyRoom = new Place("Комната Малыша",PlaceType.YOUNGBOYROOM);
        Performance miracleEvening = new Performance("Вечер чудес", youngBoyRoom, new Human("Малыш",CreatureType.BOY));

        they.addMessage("КОНФЕТЫ ПОЛУЧИТ КАРЛСОН");
        gunilla.setPlace(street);
        krister.setPlace(street);
        // TODO: нужно передавать объект, а не сообщение
        if(they.getPlace().equals(gunilla.getPlace())) {
            gunilla.sayExactMessage(they,miracleEvening);
        }
        else{
            System.out.println("На улице никого");
        }

        for(Human human : they.getHumans()) {
            if (human.getBalance() >= 5) {
                System.out.println();
                human.setPlace(nexttoshop);
                human.buySweets(magaz);
            }
        }
    }
}
