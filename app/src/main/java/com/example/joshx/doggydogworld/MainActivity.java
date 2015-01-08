package com.example.joshx.doggydogworld;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {


    static final private String TAG = "MainActivity";


    EditText mAmountInput;
    Button mWithdrawalButton;
    Button mDepositButton;
    TextView mAmountDisplay;
    BankAccount mCurrentAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(200);
        arrayList.add(300);

        String[] numbers = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

        for(String number : numbers){
            String song = String.format(getResources().getString(R.string.songFormat), number);
            Log.d(TAG, song);

        }



        Log.d(TAG, "The size of the array is dynamic and is currently: " +arrayList.size());

        //creating the bank account object, though the static variables already exist prior to object instantiation
        mCurrentAccount = new BankAccount(BankAccount.Type.SAVINGS);

        //some fetching of objects
        mAmountDisplay = (TextView) findViewById(R.id.balance_display);
        mDepositButton = (Button) findViewById(R.id.deposit_button);
        mWithdrawalButton = (Button) findViewById(R.id.withdrawal_button);
        mAmountInput = (EditText) findViewById(R.id.amount_input);

        mWithdrawalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount = mAmountInput.getText().toString();
                mCurrentAccount.withdrawal(Double.parseDouble(amount));
                mAmountDisplay.setText("Balance is " + mCurrentAccount.getBalance());
            }
        });

        mDepositButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = mAmountInput.getText().toString();
                mCurrentAccount.deposit(Double.parseDouble(amount));
                mAmountDisplay.setText("Balance is " + mCurrentAccount.getBalance());
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
