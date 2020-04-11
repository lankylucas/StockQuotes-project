package com.example.stockquotes_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {


        Button submit;
        TextView weekOutput;
        TextView nameOutput;
        EditText nameInput;
        TextView symbolOutput;
        TextView priceOutput;
        TextView timeOutput;
        TextView changeOutput;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            nameInput = (EditText) findViewById(R.id.nameInput);
            symbolOutput = findViewById(R.id.symbolOutput);
            nameOutput = findViewById(R.id.nameOutput);
            priceOutput = findViewById(R.id.priceOutput);
            timeOutput = findViewById(R.id.timeOutput);
            changeOutput = findViewById(R.id.changeOutput);
            weekOutput = findViewById(R.id.weekOutput);
            submit = findViewById(R.id.submit);

            //task.delegate = this;

            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pull task = new pull(symbolOutput, nameOutput, priceOutput, timeOutput, changeOutput, weekOutput, getApplicationContext());
                    task.execute(nameInput.getText().toString());

                }
            });


        }


        @Override
        protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
            super.onRestoreInstanceState(savedInstanceState);
            nameInput.setText(savedInstanceState.getString("input"));
            symbolOutput.setText(savedInstanceState.getString("symbol"));
            nameOutput.setText(savedInstanceState.getString("name"));
            priceOutput.setText(savedInstanceState.getString("price"));
            timeOutput.setText(savedInstanceState.getString("time"));
            changeOutput.setText(savedInstanceState.getString("change"));
            weekOutput.setText(savedInstanceState.getString("week"));

        }

        @Override
        protected void onSaveInstanceState(@NonNull Bundle outState) {
            super.onSaveInstanceState(outState);
            String input = nameInput.getText().toString();
            outState.putString("input", input);
            outState.putString("symbol", symbolOutput.getText().toString());
            outState.putString("name", nameOutput.getText().toString());
            outState.putString("price", priceOutput.getText().toString());
            outState.putString("time", timeOutput.getText().toString());
            outState.putString("change", changeOutput.getText().toString());
            outState.putString("week", weekOutput.getText().toString());

        }


    }
}