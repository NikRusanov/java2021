package com.rusanov;

public class Transfer {


    public  void transferMoney(Account fromAccount, Account toAccount, int summ) {
        try {
            fromAccount.transfer(toAccount, summ);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
