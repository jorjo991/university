package com.solvd.university.thread;

import java.time.temporal.TemporalUnit;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

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

        CompletableFuture stringCompletableFuture = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(200);
                System.out.println("CompletableFuture 1 is running");
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        });

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two number");
        int var1 = scanner.nextInt();
        int var2 = scanner.nextInt();
        CompletableFuture<Integer> fun1 = CompletableFuture.supplyAsync(() -> var1);
        CompletableFuture<Integer> fun2 = CompletableFuture.supplyAsync(() -> var2);
        fun1.thenCombine(fun2, Integer::sum).thenAccept(System.out::println);

    }
}
