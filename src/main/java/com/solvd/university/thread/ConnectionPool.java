package com.solvd.university.thread;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPool {

    public static volatile ConnectionPool connectionPool;

    public final int maxSize;
    public final Semaphore semaphore;
    public Queue<MockConnection> availableConnections;
    public final AtomicInteger created = new AtomicInteger(0);

    public ConnectionPool(int maxSize) {
        this.maxSize = maxSize;
        this.semaphore = new Semaphore(maxSize, true);
        this.availableConnections = new ConcurrentLinkedDeque<>();
    }

    public static ConnectionPool getConnectionPool(int maxSize) {
        if (connectionPool == null) {
            synchronized (ConnectionPool.class) {
                if (connectionPool == null) {
                    connectionPool = new ConnectionPool(maxSize);
                }
            }
        }
        return connectionPool;
    }

    public MockConnection getConnection() throws InterruptedException {
        semaphore.acquire();
        MockConnection mockConnection = availableConnections.poll();
        if (mockConnection == null) {
            mockConnection = new MockConnection("Connection " + created.incrementAndGet());
        }
        return mockConnection;
    }

    public void release(MockConnection connection) {
        if (connection != null) {
            availableConnections.offer(connection);
            semaphore.release();
        }
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public int getAvailableNumber() {
        return availableConnections.size();
    }

    public AtomicInteger getCreated() {
        return this.created;
    }
}
