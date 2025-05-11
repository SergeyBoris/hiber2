package web.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum Rating {
    G("G"),
    PG("PG"),
    PG13("PG-13"),
    R("R"),
    NC17("NC-17");

    public String value;
     Rating(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Rating getRatingByValue(String value) {
        if(value == null || value.isEmpty()) return null;
        Rating[] values = Rating.values();
        for (Rating rating : values) {
            if(rating.value.equals(value)) {
                return rating;
            }
        }
        return null;
    }
}
