package course.labs.healthinmind.common;

public enum Form {
    PILL("Pill"), LIQUID("LIQUID");

    private String value;

    Form(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
