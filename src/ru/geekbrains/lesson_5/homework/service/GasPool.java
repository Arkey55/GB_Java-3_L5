package ru.geekbrains.lesson_5.homework.service;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class GasPool {
    private static float poolSize = 200f;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void info (){
        lock.readLock().lock();
        System.out.println("Fuel left in GasPool: " + poolSize);
        lock.readLock().unlock();
    }

    public boolean request (float amount){
        lock.writeLock().lock();
        try {
            info();
            if ((poolSize - amount) < 0){
                return false;
            }
            poolSize -= amount;
            return true;
        } finally {
            lock.writeLock().unlock();
        }
    }
}
