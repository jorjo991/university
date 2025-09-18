package repository;

import java.util.Set;

public class RepositoryImpl<T> implements Repository<T> {

    private Set<T> userList;

    public RepositoryImpl(Set<T> userList) {
        this.userList = userList;
    }

    @Override
    public void register(T o) {
        userList.add(o);
    }

    @Override
    public Set<T> getAll() {
        return userList;
    }
}
