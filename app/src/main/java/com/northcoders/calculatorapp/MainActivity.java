package com.northcoders.calculatorapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText firstNumberInput;
    EditText secondNumberInput;
    Button addButton;
    TextView result;
    Button clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        firstNumberInput = findViewById(R.id.firstNumberInput);
        secondNumberInput = findViewById(R.id.secondNumberInput);
        addButton = findViewById(R.id.addButton);
        result = findViewById(R.id.result);
        clearButton = findViewById(R.id.clearButton);

        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                addNumbers();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearButton();
            }
        });
    }

    public void addNumbers() {
                String firstNumber = firstNumberInput.getText().toString();
                String secondNumber = secondNumberInput.getText().toString();

                if (!firstNumber.isEmpty() && !secondNumber.isEmpty()) {
                    int firstNumberInt = Integer.parseInt(firstNumber);
                    int secondNumberInt = Integer.parseInt(secondNumber);

                    int resultInt = firstNumberInt + secondNumberInt;

                    result.setText(String.valueOf(resultInt));
                    Log.i("Result: ", String.valueOf(result));
                } else {
                    result.setText("Please enter two numbers");
                }
            }

            public void clearButton() {
            firstNumberInput.setText("");
            secondNumberInput.setText("");
            result.setText("");
            }
        }
