package ru.amorozov.patterns;

import ru.amorozov.patterns.abstractFactory.CarsFactory;
import ru.amorozov.patterns.abstractFactory.ToyotaFactory;
import ru.amorozov.patterns.builder.AutomotiveEngineer;
import ru.amorozov.patterns.builder.Car;
import ru.amorozov.patterns.builder.CarBuilder;
import ru.amorozov.patterns.builder.SportsCarBuilder;

public class Main {

	public static void main(String[] args) {
		CarBuilder builder = new SportsCarBuilder();
		AutomotiveEngineer engineer = new AutomotiveEngineer(builder);
		Car car = engineer.manufactureCar();
		if (car != null) {
			System.out.println("Below car delievered: ");
			System.out.println("======================================================================");
			System.out.println(car);
			System.out.println("======================================================================");
		}


		CarsFactory factory;
		factory = new ToyotaFactory();
		factory.createSedan();

	}

}
