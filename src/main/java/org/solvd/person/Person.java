package org.solvd.person;

import org.solvd.registration.Registrable;

import java.util.Objects;

public abstract class Person implements Registrable {

    private static int countPerson;

    private Integer id;
    private Integer age;
    private String name;
    private String surname;
    private Gender gender;

    public Person(Integer id, Integer age, String name, String surname, Gender gender) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }

    public abstract void getInfo();

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(age, person.age) && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name, surname, gender);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                '}';
    }

    public static int getCountPerson() {
        return countPerson;
    }

    public static void setCountPerson(int countPerson) {
        Person.countPerson = countPerson;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
