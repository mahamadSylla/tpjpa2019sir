package jpa;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class CustomDateDeserializer extends JsonDeserializer<Date>{
	
	private SimpleDateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		String date = jp.getText();
        try {
            return new java.sql.Date(formatter.parse(date).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
	}

}

