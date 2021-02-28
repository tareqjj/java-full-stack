package com.BankAccount;

import com.BankAccount.BankAccount;

public class TestBankAccount {
    public static void main(String[] args){
        BankAccount acc1 = new BankAccount();
        BankAccount acc2 = new BankAccount();
        acc1.displayBalance();
        acc1.deposite("Checking", 100);
        acc1.deposite("Savings", 200);
        acc1.displayBalance();
        acc1.withdraw("Checking",20);
        acc1.withdraw("Savings", 50);
        acc1.displayBalance();
        BankAccount.displayAllAcc();
    }
}
