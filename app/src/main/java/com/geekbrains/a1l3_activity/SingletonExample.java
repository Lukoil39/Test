package com.geekbrains.a1l3_activity;

public class SingletonExample {
    private static SingletonExample instance = null;

    int counter = 0;
    String userName = "Ivan Ivanov";

    private SingletonExample() {}

    public static SingletonExample getInstance() {
        if(instance == null) {
            instance = new SingletonExample();
        }

        return instance;
    }
}
