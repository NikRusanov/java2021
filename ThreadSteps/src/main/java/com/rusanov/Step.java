package com.rusanov;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Step extends  Thread{

    final static Lock lock = new ReentrantLock();
    final private String  name;
    public Step(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this.name);

            try {
                lock.lock();
                Step.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }


        }
    }

}
