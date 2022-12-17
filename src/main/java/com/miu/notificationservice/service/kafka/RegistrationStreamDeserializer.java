package com.miu.notificationservice.service.kafka;

import org.apache.kafka.common.serialization.Deserializer;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;


public class RegistrationStreamDeserializer implements Deserializer<RegistrationStream> {
    public static final ObjectMapper mapper = JsonMapper.builder()
            .findAndAddModules()
            .build();

    @Override
    public RegistrationStream deserialize(String s, byte[] data) {
        try {
            return mapper.readValue(data, RegistrationStream.class);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }
}
