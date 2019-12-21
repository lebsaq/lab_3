package Types;

public enum PlaceType {
    STREET("street"),
    YOUNGBOYSPLACE("youngboysplace"),
    ROOF("roof"),
    NONE("none"),
    NEXTTOSHOP("nexttshop"),
    UNKNOWN("unknown"),
    ;

    private String placeType;

    PlaceType(String placeType){
        this.placeType = placeType;
    }

    private String getPlaceType(){
        return this.placeType;
    }

    @Override
    public String toString() {
        return this.getPlaceType();
    }
}
