package org.solvd.lamdafucntion;

import org.solvd.person.Person;

import java.util.List;

@FunctionalInterface
public interface AverageCalculator {

    double averageAge(List<? extends Person> personList);
}
