package com.glqdlt.example.jpainheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Jhun
 * 2019-10-21
 */
@Entity
@DiscriminatorValue(value= "1")
public class Bird extends Animal {
    public Bird() {
    }

    private Integer wings;

    @Column(name= "wings")
    public Integer getWings() {
        return wings;
    }

    public void setWings(Integer wings) {
        this.wings = wings;
    }
}
