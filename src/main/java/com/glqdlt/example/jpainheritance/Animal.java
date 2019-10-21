package com.glqdlt.example.jpainheritance;


import javax.persistence.*;
import java.util.stream.Stream;

/**
 * @author Jhun
 * 2019-10-21
 */
@Entity
@DiscriminatorColumn(name = "animal_type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Animal {

    public enum TypeEnum {
        DOG(AnimalTypeMapper.BIRD),
        BIRD(AnimalTypeMapper.DOG);

        private String key;

        public String getKey() {
            return key;
        }

        TypeEnum(String key) {
            this.key = key;
        }

        public static TypeEnum valueOf(Integer dbData){
            String z = dbData.toString();
            return Stream.of(TypeEnum.values())
                    .filter(x -> x.getKey().equals(z))
                    .findAny().orElseThrow(() -> new RuntimeException(String.format("Not Founded Data : %s",dbData)));
        };
    }

    private Integer seq;
    private String name;
    private TypeEnum type;

    @Convert(converter = AnimalTypeMapper.class)
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
