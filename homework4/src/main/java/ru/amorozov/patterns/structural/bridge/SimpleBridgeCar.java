package ru.amorozov.patterns.structural.bridge;

public class SimpleBridgeCar extends BridgeCar {
    public SimpleBridgeCar(BridgeEngine bridgeEngine) {
        super(bridgeEngine);
    }

    public void SetBridgeEngine() {
        System.out.println("Simple car engine (bridge): ");
        bridgeEngine.SetBridgeEngine();
    }
}
