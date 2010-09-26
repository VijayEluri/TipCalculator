package net.liquidorange;

import java.text.NumberFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculator extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /*
         * Hidden view used for error messages
         */
        final TextView errorMessage = (TextView) findViewById(R.id.errorMessage);
        
        final EditText billAmount = (EditText) findViewById(R.id.billAmount);
        final Button calculateButton = (Button) findViewById(R.id.calculateTip);
        
        /*
         * Table View Fields
         */
        final TextView tenPercentTableTip = (TextView) findViewById(R.id.tenPercent);
        final TextView tenPercentTableTotal= (TextView) findViewById(R.id.tenPercentTotal);
        
        final TextView fifteenPercentTableTip = (TextView) findViewById(R.id.fifteenPercent);
        final TextView fifteenPercentTableTotal= (TextView) findViewById(R.id.fifteenPercentTotal);
        
        final TextView eighteenPercentTableTip = (TextView) findViewById(R.id.eighteenPercent);
        final TextView eighteenPercentTableTotal= (TextView) findViewById(R.id.eighteenPercentTotal);
        
        final TextView twentyPercentTableTip = (TextView) findViewById(R.id.twentyPercent);
        final TextView twentyPercentTableTotal= (TextView) findViewById(R.id.twentyPercentTotal);
        
        
        calculateButton.setOnClickListener(new Button.OnClickListener() {
        	
			public void onClick(View v) {
				NumberFormat format = NumberFormat.getCurrencyInstance();
				
				String billPrice = billAmount.getText().toString();
				Float billPriceAsFloat = 0.0F;
				try {
					 //Check for dollar sign
					char c = billPrice.charAt(0);
					if (c == '$') {
						billPrice = billPrice.substring(1, billPrice.length());
					}
					billPriceAsFloat = Float.valueOf(billPrice);
					errorMessage.setVisibility(View.INVISIBLE);
				} catch (NumberFormatException e) {
					errorMessage.setText(R.string.invalidNumber);
					errorMessage.setVisibility(View.VISIBLE);
					return;
				} catch (Exception npe) {
					errorMessage.setText(R.string.invalidNumber);
					errorMessage.setVisibility(View.VISIBLE);
					return;
				}
				
				/*
				 * Calculate Tips
				 */
				Float tenPercentCalc = billPriceAsFloat * 1.10F;
				Float tenPercentTip = billPriceAsFloat * .10F;
				
				Float fifteenPercentCalc = billPriceAsFloat * 1.15F;
				Float fifteenPercentTip = billPriceAsFloat * .15F;
				
				Float eighteenPercentCalc = billPriceAsFloat * 1.18F;
				Float eighteenPercentTip = billPriceAsFloat * .18F;
				
				Float twentyPercentCalc = billPriceAsFloat * 1.20F;
				Float twentyPercentTip = billPriceAsFloat * .20F;
				
				/*
				 * Populate table rows
				 */
				tenPercentTableTip.setText(format.format(tenPercentTip));
				tenPercentTableTotal.setText(format.format(tenPercentCalc));
				
				fifteenPercentTableTip.setText(format.format(fifteenPercentTip));
				fifteenPercentTableTotal.setText(format.format(fifteenPercentCalc));
				
				eighteenPercentTableTip.setText(format.format(eighteenPercentTip));
				eighteenPercentTableTotal.setText(format.format(eighteenPercentCalc));
				
				twentyPercentTableTip.setText(format.format(twentyPercentTip));
				twentyPercentTableTotal.setText(format.format(twentyPercentCalc));
			}
			
        });
    }
}