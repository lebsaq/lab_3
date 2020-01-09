package Types;

public enum PlaceType {
    STREET("street"),
    YOUNGBOYROOM("youngBoyRoom"),
    ROOF("roof"),
    NONE("none"),
    NEXTTOSHOP("nexttoshop"),
    UNKNOWN("unknown"),
    ;

    private String placeType;

    PlaceType(String placeType) {
        this.placeType = placeType;
    }

    private String getPlaceType() {
        return this.placeType;
    }

    @Override
    public String toString() {
        return this.getPlaceType();

    }
}
