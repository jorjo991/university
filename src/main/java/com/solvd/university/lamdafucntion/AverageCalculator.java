package com.solvd.university.lamdafucntion;

import com.solvd.university.person.Person;

import java.util.List;

@FunctionalInterface
public interface AverageCalculator {

    double averageAge(List<? extends Person> personList);
}
