package ru.geekbrains.lesson_5.homework.entity;

import ru.geekbrains.lesson_5.homework.service.GasStation;

import static java.lang.Thread.sleep;

public class Vehicle implements Runnable{
    private String name;
    private float tankSize;
    private float fuelConsumption;
    private float fuelLeftInTank;
    private static GasStation gasStation = new GasStation();


    public Vehicle(String name, float tankSize, float fuelConsumption, float fuelLeftInTank) {
        this.name = name;
        this.tankSize = tankSize;
        this.fuelConsumption = fuelConsumption;
        this.fuelLeftInTank = fuelLeftInTank;
    }

    private void drive(){
        System.out.println(String.format("[%s]: starts with %s fuel in the tank", name, fuelLeftInTank));

        while ((fuelLeftInTank - fuelConsumption) >= 0){
            try {
                fuelLeftInTank -= fuelConsumption;
                System.out.println(String.format("[%s] is driving, fuel left %s", name, fuelLeftInTank));
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(String.format("[%s]: no fuel left to drive further [%s], going to GasStation", name, fuelLeftInTank));

        float amount = tankSize - fuelLeftInTank;
        if (gasStation.refuel(amount, name)){
            fuelLeftInTank += amount;
            drive();
        } else {
            System.out.println(String.format("[%s]: not going anywhere", name));
        }
    }

    @Override
    public void run() {
        drive();
    }
}
