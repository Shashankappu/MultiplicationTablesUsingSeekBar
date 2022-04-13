package com.example.tables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public SeekBar sBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sBar = (SeekBar) findViewById(R.id.seekBar);
        sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                showTable(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        showTable(sBar.getProgress());
    }
        public void showTable(int num) {
            TextView textView = findViewById(R.id.textView1);
            textView.setText("Multiplication table of " + num);
            ArrayList<String> table = new ArrayList<>();
                for (int j = 1; j <= 10; j++) {
                    String s = num + " x " + j + " = " + (num * j);
                    table.add(s);
                }
            ListView tables = findViewById(R.id.tableslist);
            ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, table);
            tables.setAdapter(ad);
        }
    }


