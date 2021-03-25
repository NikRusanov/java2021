package com.rusanov;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Step extends  Thread{


    final private String  name;
    private final Object lock;
    public Step(String name, Object lock) {
        this.name = name;
        this.lock = lock;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                lock.notify();
                System.out.println(name + "step");

                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
