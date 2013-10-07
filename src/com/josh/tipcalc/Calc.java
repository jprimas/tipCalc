package com.josh.tipcalc;

import java.text.NumberFormat;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Calc extends Activity {
	private TextView tAmt;
	private TextView tTip;
	private TextView tTotal;
	private double percentage;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
    	tAmt = (TextView) findViewById(R.id.tAmt);
    	tTip = (TextView) findViewById(R.id.tTip);
    	tTotal = (TextView) findViewById(R.id.tTotal);
    	tTip.setText("");
    	tTotal.setText("");
    	percentage = 0;
    	setupListViewListner();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calc, menu);
        return true;
    }
    
    private void setupListViewListner(){
    	tAmt.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable s) {
				if(percentage != 0){
					calcTip(percentage);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {}
            
        }); 
    }
    
    public void tip10(View v){
    	this.calcTip(.10);
    }
    public void tip15(View v){
    	this.calcTip(.15);
    }
    public void tip20(View v){
    	this.calcTip(.20);
    }
    
    private void calcTip(double percentage){
    	this.percentage = percentage;
    	double amt;
    	try{
    		amt = Double.parseDouble(tAmt.getText().toString());
    	} catch(Exception e) {
    		tTip.setText("Error");
    		tTotal.setText("Error");
    		return;
    	}
    	double tip = amt * percentage;
    	double newAmt = amt + tip;
    	NumberFormat fmt = NumberFormat.getCurrencyInstance();
    	tTip.setText(fmt.format(tip));
    	tTotal.setText(fmt.format(newAmt));
    }
    
}
