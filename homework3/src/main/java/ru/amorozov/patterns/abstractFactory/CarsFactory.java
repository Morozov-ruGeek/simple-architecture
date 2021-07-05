package ru.amorozov.patterns.abstractFactory;

public interface CarsFactory {
    Sedan createSedan();
    Coupe createCoupe();
}
