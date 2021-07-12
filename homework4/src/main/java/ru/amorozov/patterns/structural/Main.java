package ru.amorozov.patterns.structural;

import ru.amorozov.patterns.structural.bridge.SimpleBridgeCar;
import ru.amorozov.patterns.structural.bridge.SimpleBridgeEngine;
import ru.amorozov.patterns.structural.bridge.SportBridgeCar;
import ru.amorozov.patterns.structural.bridge.SportBridgeEngine;
import ru.amorozov.patterns.structural.facade.Facade;
import ru.amorozov.patterns.structural.сomposite.Car;
import ru.amorozov.patterns.structural.сomposite.Drawing;
import ru.amorozov.patterns.structural.сomposite.SimpleCar;
import ru.amorozov.patterns.structural.сomposite.SportCar;

public class Main {
    public static void main(String[] args) {

//       Pattern composite check
        System.out.println("Composite pattern");
        Car sportCar = new SportCar();
        Car unknownCar = new SimpleCar();
        Drawing drawing = new Drawing();
        drawing.add(sportCar);
        drawing.add(unknownCar);
        drawing.draw("green");
        drawing.clear();
        drawing.add(sportCar);
        drawing.add(unknownCar);
        drawing.draw("white");
        System.out.println();

//       Pattern facade check
        System.out.println("Facade pattern");
        Facade facade = new Facade();
        facade.startCar();
        System.out.println();
        facade.stopCar();
        System.out.println();

//        Pattern bridge check
        System.out.println("Bridge pattern");
        SportBridgeCar sportBridgeCar = new SportBridgeCar(new SportBridgeEngine());
        sportBridgeCar.SetBridgeEngine();
        System.out.println();
        SimpleBridgeCar simpleBridgeCar = new SimpleBridgeCar(new SportBridgeEngine());
        simpleBridgeCar.SetBridgeEngine();
    }
}
