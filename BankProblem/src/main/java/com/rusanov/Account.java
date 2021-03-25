package com.rusanov;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private final String id;
    private Integer balance;
    private final Lock lock = new ReentrantLock();
    private static final int TIME_TO_SLEEP = 200;
    public Account(String id, Integer balance){
        this.id = id;
        this.balance = balance;
    }

    public Integer getBalance() {return this.balance;}
    public String getId() {return this.id;}

    public void decrement(int summ) {this.balance -= summ;}
    public void increment(int summ) {this.balance += summ;}


    // Если первый аккаунт не используется, блокируем и проверяем второй аккаунт.
    // Если и со вторым все нормально, блокируем и его, делаем перевод и выходим из цикла
    // В finally блоках снимаем блокировки
    // Если же второй занят, то снимаем блокировку первого и ждем, затем повторяем
    public void transfer(Account toAcc, int amount) throws InterruptedException {
        while (true) {
            if(this.lock.tryLock()) {
                try {
                    if(toAcc.lock.tryLock()) {
                        try {
                            if(amount > balance) {
                                throw new IllegalArgumentException("Not enough money on " + id);
                            }
                            toAcc.increment(amount);
                            this.decrement(amount);
                            break;
                        } finally {
                            toAcc.lock.unlock();
                        }
                    }
                } finally {
                    this.lock.unlock();
                }
                Thread.sleep(TIME_TO_SLEEP);
            }
        }
    }
}
