package com.josh.tipcalc;

import java.text.NumberFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class Calc extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        TextView tTip = (TextView) findViewById(R.id.tTip);
    	TextView tTotal = (TextView) findViewById(R.id.tTotal);
    	tTip.setText("");
    	tTotal.setText("");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calc, menu);
        return true;
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
    	TextView tAmt = (TextView) findViewById(R.id.tAmt);
    	TextView tTip = (TextView) findViewById(R.id.tTip);
    	TextView tTotal = (TextView) findViewById(R.id.tTotal);
    	double amt;
    	try{
    		amt = Double.parseDouble(tAmt.getText().toString());
    	} catch(Exception e) {
    		tTip.setText("Error");
    		return;
    	}
    	double tip = amt * percentage;
    	double newAmt = amt + tip;
    	NumberFormat fmt = NumberFormat.getCurrencyInstance();
    	tTip.setText(fmt.format(tip));
    	tTotal.setText(fmt.format(newAmt));
    }
    
}
