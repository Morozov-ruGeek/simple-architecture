package ru.amorozov.patterns.structural.bridge;

public class SportBridgeCar extends BridgeCar{

    public SportBridgeCar(BridgeEngine bridgeEngine) {
        super(bridgeEngine);
    }

    public void SetBridgeEngine() {
        System.out.println("Sport car engine (bridge): ");
        bridgeEngine.SetBridgeEngine();
    }
}
