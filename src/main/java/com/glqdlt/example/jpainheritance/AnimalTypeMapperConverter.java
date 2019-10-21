package com.glqdlt.example.jpainheritance;

import javax.persistence.AttributeConverter;

/**
 * @author Jhun
 * 2019-10-21
 */
public class AnimalTypeMapperConverter implements AttributeConverter<Animal.TypeEnum, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Animal.TypeEnum attribute) {
        return Integer.parseInt(attribute.getKey());
    }

    @Override
    public Animal.TypeEnum convertToEntityAttribute(Integer dbData) {
        return Animal.TypeEnum.valueOf(dbData);
    }
}
