package Types;

public enum CreatureType {
    HUMAN("human"),
    BOY("boy"),
    GIRL("girl"),
    NONE("none"),
    OTHER("other"),
    KARLSON("karlson"),
    ;

    private String strType;

    CreatureType(String strType){
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
