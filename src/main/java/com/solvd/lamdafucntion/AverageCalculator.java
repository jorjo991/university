package com.solvd.lamdafucntion;

import com.solvd.person.Person;

import java.util.List;

@FunctionalInterface
public interface AverageCalculator {

    double averageAge(List<? extends Person> personList);
}
