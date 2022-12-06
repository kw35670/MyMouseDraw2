// https://howcang.com/2021/02/17/paint/
package com.example.mymousedraw2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private Button clearButton;
    private MyCanvas myCanvas;
    Button red_button,blue_button,green_button,black_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews();
        setListeners();
        myCanvas.setLineColor(Color.BLACK);
        myCanvas.setLineStrokeWidth(10);

//        色変更
        RadioGroup LineColor = (RadioGroup) findViewById(R.id.LineColor);
        LineColor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                String text = radioButton.getText().toString();
                switch (text) {
                    case "赤":
                        myCanvas.setLineColor(Color.RED);
                        break;
                    case "緑":
                        myCanvas.setLineColor(Color.GREEN);
                        break;
                    case "青":
                        myCanvas.setLineColor(Color.BLUE);
                        break;
                    case "黒":
                        myCanvas.setLineColor(Color.BLACK);
                        break;
                }
            }
        });

//        太さ変更
        RadioGroup LineWeight = (RadioGroup) findViewById(R.id.LineWeight);
        LineWeight.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                String text = radioButton.getText().toString();
                switch (text) {
                    case "細い":
                        myCanvas.setLineStrokeWidth(5);
                        break;
                    case "普通":
                        myCanvas.setLineStrokeWidth(10);
                        break;
                    case "太い":
                        myCanvas.setLineStrokeWidth(20);
                        break;
                }
            }
        });
    }

    private void getViews() {
        myCanvas = findViewById(R.id.myCanvas);
        clearButton = findViewById(R.id.clear);
    }

    private void setListeners() {
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // クリア処理
                myCanvas.clearCanvas();
            }
        });
    }
}