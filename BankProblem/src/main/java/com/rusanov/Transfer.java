package com.rusanov;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Transfer {


    private  final Lock lock = new ReentrantLock();

    /*
     * Проблемы:
     * 1. Вызов метода во многих потоках, баланс обновился в одном
     * потоке, а в другом еще не успел обновиться.
     * 2. ??? Недостаточно средств для перевода
     * Решение: Если один из аккаунта уже проходит транзакцию,
     * то остальным переводам(c данными акаунтами(???))  надо подождать.
     */
    public  void transferMoney(Account acc1, Account acc2, int summ) {
        try {
            if(lock.tryLock(1, TimeUnit.SECONDS)) {
                if(acc1.getBalance() < summ) {
                    System.out.println("Not enough money"); return;}
                acc1.decrement(summ);
                acc2.increment(summ);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
