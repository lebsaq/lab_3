package Types;

public enum ItemType {
    NONE("none"),
    SWEET("sweet"),
    MONEY("ere"),
    ;
    private String strType;

    ItemType(String strType){
        this.strType = strType;
    }

    private String getStrType(){
        return this.strType;
    }

    @Override
    public String toString() {
        return this.getStrType();
    }
}
