package edu.orangecoastcollege.cs273.kfrederick5.tipcalculator;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * A program used to calculate the tip of a bill.
 */
public class MainActivity extends AppCompatActivity {

    private static NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static NumberFormat percent = NumberFormat.getPercentInstance();

    //Associate the controller with the needed views
    private EditText amountEditText;
    private TextView amountTextView;
    private TextView percentTextView;
    private SeekBar percentSeekBar;
    private TextView tipTextView;
    private TextView totalTextView;

    //Associate the controller with needed model
    RestaurantBill currentBill = new RestaurantBill();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect the controller with widgets in our app
        amountEditText = (EditText) findViewById(R.id.amountEditText);
        amountTextView = (TextView) findViewById(R.id.amountTextView);
        percentTextView = (TextView) findViewById(R.id.percentTextView);
        percentSeekBar = (SeekBar) findViewById(R.id.percentSeekBar);
        tipTextView = (TextView) findViewById(R.id.tipTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);

        //Define a listener for the amountEditText onTextChange
        amountEditText.addTextChangedListener(amountTextChangedListener);
        //Define a listener for the percentSeekBar (onProgressChanged);
        percentSeekBar.setOnSeekBarChangeListener(percentChangedListener);

        currentBill.setTipPercent(.20);
    }

    private TextWatcher amountTextChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            //Do nothing
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            //Try to get the amount from amountEditText:
            try
            {
                double amount = charSequence.length() > 0
                        ?Double.parseDouble(charSequence.toString()) / 100.0 : 0.0;
                currentBill.setAmount(amount);
            }
            catch (NumberFormatException e)
            {
                amountEditText.setText("");
            }

            //No exception is thrown
            //1) Set reg amount first
            amountTextView.setText(currency.format(currentBill.getAmount()));
            updateViews();
        }


        @Override
        public void afterTextChanged(Editable editable) {
            //Do nothing
        }
    };

    private SeekBar.OnSeekBarChangeListener percentChangedListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            //Update model with new tip
            currentBill.setTipPercent(i / 100.0);

            //Update the percentTextView
            percentTextView.setText(percent.format(currentBill.getTipPercent()));

            //Update the other views
            updateViews();

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private void updateViews()
    {
        //2) Set the tip amount (tipTextView)
        tipTextView.setText(currency.format(currentBill.getTipAmount()));
        //3)Set Total amount
        totalTextView.setText(currency.format(currentBill.getTotalAmount()));
    }
}


