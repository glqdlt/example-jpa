package com.glqdlt.example.jpainheritance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Jhun
 * 2019-10-21
 */
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findAllByType(Animal.TypeEnum type);
}
