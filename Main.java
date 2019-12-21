import Creatures.*;
import Trash.*;
import Types.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*
        Итак, они решили, что все конфеты получит Карлсон, который живет на крыше.
        Кристер и Гунилла выбежали на улицу и рассказали всем детям, что наверху у Малыша сейчас
        начнется большое представление "Вечер чудес".
        И все, у кого было хотя бы пять эре, побежали в лавку и купили там "входные конфеты".
        */
        Place street = new Place("Street", PlaceType.STREET);
        Place nexttoshop = new Place("nexttoshop", PlaceType.NEXTTOSHOP);
        They they = new They(10, "Они");
        they.setPlace(street);
        Shop magaz = new Shop();
        Boy krister = new Boy("Федя");
        Girl gunilla = new Girl ("Катька");
        magaz.addSweets(99999);
        they.sayExactMessage("КОНФЕТЫ ПОЛУЧИТ КАРЛСОН");
        gunilla.setPlace(street);
        krister.setPlace(street);

        Performance miracleEvening = new Performance("Вечер чудес", new Place("Комната Малыша",PlaceType.YOUNGBOYSPLACE));
        //TODO: дети должны быть на улице
        //TODO: нужно передавать не строчку, а само событие
        if(they.getPlace().equals(gunilla.getPlace())) {
            gunilla.sayExactMessage(they,miracleEvening);
        }
        else{
            System.out.println("На улице никого");
        }
        List<Human> humanList = new ArrayList<>();
        for(Human human : they.getHumans()) {
            if (human.getBalance() >= 5) {
                human.setPlace(nexttoshop);
              //  System.out.println(human.getBalance());
                human.buySweets(magaz);
            }
        }
    }
}
