package ru.geekbrains.lesson_5.homework;

import ru.geekbrains.lesson_5.homework.entity.Bus;
import ru.geekbrains.lesson_5.homework.entity.Car;
import ru.geekbrains.lesson_5.homework.entity.Truck;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
	Car car1 = new Car("car_1");
	Car car2 = new Car("car_2");
	Car car3 = new Car("car_3");
	Car car4 = new Car("car_4");
	Car car5 = new Car("car_5");
	Car car6 = new Car("car_6");
	Truck truck1 = new Truck("truck_1");
	Truck truck2 = new Truck("truck_2");
	Bus bus1 = new Bus("bus_1");
	Bus bus2 = new Bus("bus_2");

	ExecutorService exec = Executors.newFixedThreadPool(10);
	exec.submit(car1);
	exec.submit(car2);
	exec.submit(car3);
	exec.submit(car4);
	exec.submit(car5);
	exec.submit(car6);
    exec.submit(truck1);
    exec.submit(truck2);
    exec.submit(bus1);
    exec.submit(bus2);
    exec.shutdown();

    }
}
