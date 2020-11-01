package com.example.funapplicationofseekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     private SeekBar seekBar;
     private TextView resultTextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTextview = (TextView) findViewById(R.id.resultID);
        seekBar = (SeekBar) findViewById(R.id.seekbarID);
        resultTextview.setText("Charged Up Level:" + seekBar.getProgress() + "/" + seekBar.getMax());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                resultTextview.setTextColor(Color.GRAY);
               resultTextview.setText("Charged Up Level:" + seekBar.getProgress() + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("SB","OnStartTrackingTouch!");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(seekBar.getProgress() >= 7){
                    resultTextview.setTextColor(Color.RED);
                }
                Log.d("SB","OnStop!");
            }
        });
    }
}