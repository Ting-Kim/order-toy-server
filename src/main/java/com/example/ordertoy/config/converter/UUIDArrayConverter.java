package com.example.ordertoy.config.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Converter
public class UUIDArrayConverter implements AttributeConverter<List<UUID>, String> {

  private final static String COMMA = ",";

  @Override
  public String convertToDatabaseColumn(List<UUID> attributes) {
    return attributes.stream()
                     .map(UUID::toString)
                     .collect(Collectors.joining(COMMA));
  }

  @Override
  public List<UUID> convertToEntityAttribute(String uuids) {
    return Arrays.stream(uuids.split(COMMA))
                 .map(UUID::fromString)
                 .collect(Collectors.toList());
  }
}
