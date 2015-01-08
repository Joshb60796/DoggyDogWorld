package com.example.joshx.doggydogworld;

import android.util.Log;

/**
 * Created by JoshX on 1/7/2015.
 */
public class SavingsAccount extends BankAccount {
    private static final String TAG = "SavingsAccount";

    @Override
    public void withdrawal(double amount) {
        if (numberOfWithdrawals() >= 3) {
            return;
        }
        super.withdrawal(amount);
    }
}
