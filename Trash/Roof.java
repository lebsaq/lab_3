package Trash;

import Types.PlaceType;

public class Roof extends Place{
    public Roof(String name, PlaceType placeType) {
        this.name=name;
        this.type=placeType;
    }

    class Bed{
        String size;
        int comfort;
        Bed(String size, int comfort){
            this.size=size;
            this.comfort=comfort;
        }
    }
}
