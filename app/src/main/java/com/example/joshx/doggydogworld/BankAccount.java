package com.example.joshx.doggydogworld;

import java.util.ArrayList;

/**
 * Created by JoshX on 1/4/2015.
 */
public class BankAccount {

    private static final String TAG = "BankAccount";
    private double mBalance;
    private ArrayList<Double> mTransactions;
    public static final double OVERDRAFT_FEE = 30;

    public enum Type{
        CHECKING, SAVINGS;
    }

    private Type mType;

    BankAccount(Type accountType) {
        mTransactions = new ArrayList<Double>();
        mType = accountType;
    }

    public void withdrawal(double amount) {
mTransactions.add(-amount);
        if (getBalance() < 0) {
mTransactions.add(-OVERDRAFT_FEE);
        }
            }

    public void deposit(double amount) {

        mTransactions.add(amount);

    }

    //Below is a getter it exposes data while still keeping the variable private
    public double getBalance() {
        double total = 0;
        for (int i = 0; i < mTransactions.size(); i++) {
            total += mTransactions.get(i);
        }
        return total;

    }

}
