package ru.amorozov.patterns.structural.bridge;

abstract class BridgeCar{
    protected BridgeEngine bridgeEngine;

    public BridgeCar(BridgeEngine bridgeEngine){
        this.bridgeEngine = bridgeEngine;
    }

    abstract public void SetBridgeEngine();
}
