package ru.amorozov.patterns.structural.bridge;

public class SimpleBridgeEngine implements BridgeEngine {
    @Override
    public void SetBridgeEngine() {
        System.out.println("simple");
    }
}
