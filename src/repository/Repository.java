package repository;

import java.util.Set;

public interface Repository<T> {

    void register(T t);

    Set<T> getAll();
}
