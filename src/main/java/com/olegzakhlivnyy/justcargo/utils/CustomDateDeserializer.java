package com.olegzakhlivnyy.justcargo.utils;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import javax.validation.ValidationException;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDateDeserializer extends JsonDeserializer<OffsetDateTime> {
    private static final Pattern pattern = Pattern.compile("(\\d{4}-\\d{2}-\\d{2})[T\\s]?(\\d{2}:\\d{2}:\\d{2})?(\\.\\d{3})?\\D?(\\d{2,3}[Z:]\\d{2})?");
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException{
        String data = jsonParser.getText();
        Matcher matcher = pattern.matcher(data);
        if (matcher.find()) {
            if (matcher.group(4) != null || matcher.group(3) != null) {
                return OffsetDateTime.parse(data, DateTimeFormatter.ISO_DATE_TIME);
            } else if (matcher.group(2) != null) {
                LocalDateTime localDateTime;
                try {
                    localDateTime = LocalDateTime.parse(data, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                } catch (DateTimeParseException e) {
                    localDateTime = LocalDateTime.parse(data, dateTimeFormatter);
                }
                return localDateTime.atZone(ZoneId.systemDefault()).toOffsetDateTime();
            } else if (matcher.group(1) != null) {
                LocalDateTime localDateTime = LocalDate.parse(data, DateTimeFormatter.ISO_DATE).atStartOfDay();
                return localDateTime.atZone(ZoneId.systemDefault()).toOffsetDateTime();
            }
        }
        throw new ValidationException("Неверный формат даты: " + data);
    }
}
