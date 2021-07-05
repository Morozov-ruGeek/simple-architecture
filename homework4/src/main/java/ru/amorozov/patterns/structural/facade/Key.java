package ru.amorozov.patterns.structural.facade;

public class Key implements Car{
    public void start() {
        System.out.println("Insert key");
    }

    public void stop() {
        System.out.println("Take out the key");
    }
}
