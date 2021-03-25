package com.rusanov;

import org.junit.Test;

import static org.junit.Assert.*;

public class TransferTest {

    @Test
    public void transferTest() throws InterruptedException {
        Account account1 = new Account("1", 1000);
        Account account2 = new Account("2", 0);
        Account account3 = new Account("3", 500);
        Transfer transfer = new Transfer();
        Thread thread1 = new Thread(() -> transfer.transferMoney(account1, account2, 500));
        Thread thread2 = new Thread(() -> transfer.transferMoney(account2, account1, 250));

        //account 1:1000
        //account 2:250
        //account 3:500
        //
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        System.out.println("account 1:" + account1.getBalance());
        System.out.println("account 2:" + account2.getBalance());
        System.out.println("account 3:" + account3.getBalance());

        assertEquals(750,account1.getBalance().intValue());
        assertEquals(250,account2.getBalance().intValue());




    }
}
