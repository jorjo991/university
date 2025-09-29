package com.solvd.university.repository;

import java.util.List;

public interface Repository<T> {

    void register(T t);

    List<T> getAll();
}
