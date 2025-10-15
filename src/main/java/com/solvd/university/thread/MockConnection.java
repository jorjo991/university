package com.solvd.university.thread;

public class MockConnection {

    private final String id;

    MockConnection(String id) {
        this.id = id;
    }

    public void execute(String query) {
        System.out.println(id + " executing: " + query);
    }

    public void close() {
        System.out.println(id + " closed");
    }

    public String getId() {
        return id;
    }
}
