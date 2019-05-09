package jpa;

import java.sql.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
public class LocalDateAttributeConverter implements AttributeConverter<Date, Date> {

	public Date convertToDatabaseColumn(Date entityDate) {
		return entityDate;
	}

	public Date convertToEntityAttribute(Date dbDate) {
		return dbDate == null ? null : dbDate;
	}

}

