package ru.geekbrains.lesson_5.homework.service;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class GasStation {
    private Semaphore semaphore;
    private GasPool pool = new GasPool();

    public GasStation() {
        this.semaphore = new Semaphore(3);
    }

    public boolean refuel(float amount, String name){
        try {
            System.out.println(String.format("[%s] arrived to GasStation", name));
            semaphore.acquire();
//            pool.info();
            if (pool.request(amount)){
                System.out.println(String.format("[%s] is refueling...", name));
                sleep(5000);
                System.out.println(String.format("[%s] left GasStation.", name));
                pool.info();
                return true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        System.out.println(String.format("[%s]: there is not enough gas at station", name));
        return false;
    }
}
