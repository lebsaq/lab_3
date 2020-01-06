package Types;

public enum CreatureType {
    HUMAN("human"),
    BOY("boy"),
    GIRL("girl"),
    UNKNOWN("unknown"),
    OTHER("other"),
    KARLSON("karlson"),
    ;

    private String strType;

    CreatureType(String strType){
        this.strType = strType;
    }

    public String getStrType(){
        return this.strType;
    }

    @Override
    public String toString() {
        return this.getStrType();
    }

}
