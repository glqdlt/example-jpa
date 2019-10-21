package com.glqdlt.example.jpainheritance;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author Jhun
 * 2019-10-21
 */
public class AnimalTypeMapperTest {
    @Test
    public void name() {
        List<String> z = AnimalTypeMapper.values();
        Assert.assertEquals("1",z.get(0));
        Assert.assertEquals("0",z.get(1));
    }
}