package com.glqdlt.example.jpainheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @author Jhun
 * 2019-10-21
 */
@Entity
@DiscriminatorValue("0")
public class Dog extends Animal implements Serializable {
    public Dog() {
    }
}
