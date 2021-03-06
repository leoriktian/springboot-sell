package com.tian.sell.utils.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * @Author: tyq
 * @Date: 2018/12/6 11:23
 */
public class Date2LongSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date date, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
      gen.writeNumber(date.getTime() / 1000);
    }
}
