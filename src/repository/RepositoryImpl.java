package repository;

import java.util.Arrays;
import java.util.Objects;

public class RepositoryImpl <T> implements  Repository<T> {

    private T[] userList;
    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public RepositoryImpl(Class<T> type) {
        this.type = type;
        this.userList = (T[]) java.lang.reflect.Array.newInstance(type, 0); // Type-safe initialization
    }

    @Override
    public void register(T o) {
        if(userList!=null){
            userList= Arrays.copyOf(userList,userList.length+1);
            userList[userList.length-1]=o;
        }
    }


    @Override
    public T[] getAll() {
        return userList.clone();
    }
}
