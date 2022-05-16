package com.example.backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import javax.swing.text.AbstractDocument;

@Converter
public class JsonConverter implements AttributeConverter<AbstractDocument.Content, String> {

    @Override
    public String convertToDatabaseColumn(AbstractDocument.Content attribute) {
        try {
            return new ObjectMapper().writeValueAsString(attribute);
        } catch (Exception e) {
            //log error
            return null;
        }

    }

    @Override
    public AbstractDocument.Content convertToEntityAttribute(String dbData) {
        try {
            return new ObjectMapper().readValue(dbData, AbstractDocument.Content.class);
        } catch (Exception e) {
            //log error
            return null;
        }
    }

}
