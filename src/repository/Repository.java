package repository;

public interface Repository <T>{

    void register (T t);
    T [] getAll();
}
