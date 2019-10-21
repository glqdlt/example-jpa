package com.glqdlt.example.jpainheritance;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EnumType;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Jhun
 * 2019-10-21
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class AnimalRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private AnimalRepository animalRepository;

    @Before
    public void setUp() throws Exception {
        List<Animal> yy = IntStream.rangeClosed(1, 10)
                .boxed()
                .map(x -> {
                    Animal animal;
                    if (x % 2 == 0) {
                        animal = new Bird();
                        animal.setName("bird" + x);
                        ((Bird) animal).setWings(x);
                    } else {
                        animal = new Dog();
                        animal.setName("dog" + x);
                    }
                    return animal;
                }).collect(Collectors.toList());

        animalRepository.saveAll(yy);
    }

    @Test
    public void name() {
        List<Animal> zz = animalRepository.findAll();

        List<Animal> y = animalRepository.findAllByType(Animal.TypeEnum.BIRD);
        Animal c = y.get(0);
        Integer zzz = y.get(0).getSeq();
        System.out.println(zzz);
        c = new Dog();
        animalRepository.saveAndFlush(c);
        System.out.println(c.getSeq());
        System.out.println(animalRepository.findById(zzz).get().getSeq());

    }
}