package com.pethoalpar.androidisprimeexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;

    private boolean isPrime(double number){
        if(number < 2){
            return false;
        }else if(number == 2.0){
            return true;
        }
        int limit = (int)Math.floor(Math.sqrt(number));
        int i = 2;
        int numberInt = (int) number;
        while (i<= limit){
            if( numberInt % i == 0){
                return false;
            }
            i++;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) this.findViewById(R.id.editText);
        textView = (TextView) this.findViewById(R.id.textView);
        this.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double number = Double.parseDouble(editText.getText().toString());
                    boolean result = isPrime(number);
                    textView.setText(result? "Is prime" : "Is not prime");
                }catch (NumberFormatException e){
                    textView.setText("Invalid number format");
                }
            }
        });
    }
}
