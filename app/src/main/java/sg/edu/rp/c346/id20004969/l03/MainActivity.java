package sg.edu.rp.c346.id20004969.l03;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplay;
    Button btnDisplay;
    EditText etInput;
    ToggleButton tglButton;
    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvDisplay = findViewById(R.id.textViewDisplay);
        btnDisplay = findViewById(R.id.buttonDisplay);
        etInput = findViewById(R.id.editText);
        tglButton = findViewById(R.id.toggleButtonEnabled);
        rgGender = findViewById(R.id.radiogrp);



        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Value = etInput.getText().toString();

                if (Value.isEmpty()) {
                    tvDisplay.setText("Nothing has been entered");
                    Toast.makeText(MainActivity.this,
                            "Nothing has been entered",
                            Toast.LENGTH_SHORT).show();

                } else {
                    tvDisplay.setText(Value);
                }
            }
        });

        tglButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tglButton.isChecked()){
                    etInput.setEnabled(true);
                }else{
                    etInput.setEnabled(false);
                    etInput.setBackgroundColor(Color.GRAY);
                }

            }
        });

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringResponse = etInput.getText().toString();
                int checkedRadioId = rgGender.getCheckedRadioButtonId();
                if(checkedRadioId == R.id.radioButtonGenderMale){
                    stringResponse = "He says " + stringResponse;
                }else{
                    stringResponse = "She says " + stringResponse;
                }
                tvDisplay.setText(stringResponse);
            }
        });

    }
}