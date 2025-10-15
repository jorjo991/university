package com.solvd.university.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        ConnectionPool connectionPool = ConnectionPool.getConnectionPool(5);
        ExecutorService executorService = Executors.newFixedThreadPool(7);

        Runnable task = () -> {
            try {
                MockConnection connection = connectionPool.getConnection();
                System.out.println(Thread.currentThread().getName() + " has " + connection.getId());
                connection.execute("Select * from Students");
                Thread.sleep(500);
                connectionPool.release(connection);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < 7; i++) {
            executorService.execute(task);
        }
        executorService.shutdown();
    }
}
