import Actions.*;
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
        They they = new They("Они");
        Shop magaz = new Shop();
        Boy krister = new Boy("Федя");
        Girl gunilla = new Girl ("Катька");
        magaz.addSweets(99999);
        they.addMessage("КОНФЕТЫ ПОЛУЧИТ КАРЛСОН");
        Place street = new Place("Street", PlaceType.STREET);
        gunilla.setPlace(street);
        krister.setPlace(street);

        gunilla.sayExactMessage(they,"НАВЕРХУ У МАЛЫША ТУСА");
        Perfomance miracleEvening = new Perfomance("Вечер чудес",new Place("Комната Малыша",PlaceType.YOUNGBOYSPLACE));
        List<Human> humanList = new ArrayList<>();
        for(Human human : they.getHumans()) {
            Place nextToShop = new Place("Shop", PlaceType.NEXTTOSHOP);
            if (human.getBalance() >= 5) {
                human.setPlace(nextToShop);
                System.out.println();
                human.buySweets(magaz);
            }
        }
    }
}
