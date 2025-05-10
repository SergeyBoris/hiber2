package web.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RatingConverter implements AttributeConverter<Rating, String> {

    @Override
    public String convertToDatabaseColumn(Rating rating) {
        return rating == null ? null : rating.value;
    }

    @Override
    public Rating convertToEntityAttribute(String dbData) {
        return Rating.getRatingByValue(dbData);
    }
}