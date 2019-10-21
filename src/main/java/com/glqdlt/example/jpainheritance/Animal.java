package com.glqdlt.example.jpainheritance;


import javax.persistence.*;

/**
 * @author Jhun
 * 2019-10-21
 */
@Entity
@DiscriminatorColumn(name = "animal_type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Animal {

    public enum TypeEnum{
        DOG(0),
        BIRD(1);

        TypeEnum(Integer code) {
            this.code = code;
        }

        private Integer code;

        public Integer getCode() {
            return code;
        }
    }

    private Integer seq;
    private String name;
    private TypeEnum type;

    @Enumerated(EnumType.ORDINAL)
    @Column(insertable = false, updatable = false, name = "animal_type")
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seq")
    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
