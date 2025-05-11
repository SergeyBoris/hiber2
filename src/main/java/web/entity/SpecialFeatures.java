package web.entity;

public enum SpecialFeatures {


    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deletedscenes"),
    BEHIND_THE_SCENES("Behind the scenes");

    private final String value;
    private SpecialFeatures(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SpecialFeatures getFeatureByValue(String value){
        if(value == null || value.isEmpty()) return null;
        SpecialFeatures[] values = SpecialFeatures.values();
        for (SpecialFeatures feature : values) {
            if(feature.value.equals(value)) return feature;
        }
        return null;
    }
}
