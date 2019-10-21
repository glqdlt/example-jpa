package com.glqdlt.example.jpainheritance;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Jhun
 * 2019-10-21
 */
public class AnimalTypeMapper {
    public static final String BIRD = "1";
    public static final String DOG = "0";

    public static List<String> values() {
        final Field[] z = AnimalTypeMapper.class.getFields();
        return Stream.of(z).map(x -> {
            try {
                return x.get(null).toString();
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }).collect(toList());
    }
}
