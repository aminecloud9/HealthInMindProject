package course.labs.healthinmind.common;

public enum Form {
    PILL("Pill"),
    LIQUID("LIQUID"),
    TABLET("Tablet"),
    CAPSULES("Capsules"),
    TOPICAL_MEDICINES("Topical Medicines"),
    SUPPOSITORIES("Suppositories"),
    DROPS("Drops"),
    INHALERS("Inhalers"),
    INJECTIONS("Injections"),
    IMPANTS_OR_PATCHES("Implants or patches");

    private String value;

    Form(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
