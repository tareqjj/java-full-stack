package com.BankAccount;
import java.util.Random;

public class BankAccount {
    private String accountNumber="";
    private double checkingBalance=0.0;
    protected double savingsBalance=0.0;
    private static int numberOfAccounts=0;
    private static double balanceOfAllaccounts=0.0;

    public BankAccount(){
        this.createAccount();
        numberOfAccounts += 1;
    }

    private String createAccount(){
        Random rand = new Random();
        String str = "";
        for (int i = 0; i < 10; i++) {
            str = String.valueOf(rand.nextInt(10));
        }
        return str;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    private void setCheckingBalance(double checkingBalance) {
        this.checkingBalance += checkingBalance;
    }

    private void setSavingsBalance(double savingsBalance) {
        this.savingsBalance += savingsBalance;
    }

    public void deposite(String accType, double amount) {
        if (accType == "Checking")
            this.setCheckingBalance(amount);
        else if (accType == "Savings")
            this.setSavingsBalance(amount);
        balanceOfAllaccounts += amount;
    }

    public void withdraw(String accType, double amount) {
        if (accType == "Checking" && this.checkingBalance > amount)
            this.setCheckingBalance(-amount);
        else if (accType == "Savings" && this.checkingBalance > amount)
            this.setSavingsBalance(-amount);
        balanceOfAllaccounts -= amount;
    }

    public void displayBalance(){
        double sum = this.getCheckingBalance() + this.getSavingsBalance();
        System.out.println("Acc Balance: " + sum);
    }

    public static void displayAllAcc(){
        System.out.println("Number of Acc: " + numberOfAccounts + ", Balance of Acc " + balanceOfAllaccounts);
    }
}
