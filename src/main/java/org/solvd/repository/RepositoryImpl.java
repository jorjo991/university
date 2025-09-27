package org.solvd.repository;

import java.util.List;

public class RepositoryImpl<T> implements Repository<T> {

    private List<T> userList;

    public RepositoryImpl(List<T> userList) {
        this.userList = userList;
    }

    @Override
    public void register(T o) {
        userList.add(o);
    }

    @Override
    public List<T> getAll() {
        return getUserList();
    }

    public List<T> getUserList() {
        return userList;
    }

    public void setUserList(List<T> userList) {
        this.userList = userList;
    }
}