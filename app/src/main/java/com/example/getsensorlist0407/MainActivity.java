package com.example.getsensorlist0407;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mTxtSensors;
    SensorManager sensorMgr;
    List<Sensor> sensorList;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtSensors = findViewById(R.id.txtSensors);
        mButton = findViewById(R.id.button1);
        mButton.setOnClickListener(this);

    }

    public void onClick(View  v) {
        sensorMgr = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorList = sensorMgr.getSensorList(Sensor.TYPE_ALL);

        mTxtSensors.append("(# Sensors : " + sensorList.size() + ") \n\n");
        for(Sensor sensor : sensorList){ // Enhanced for Loop
            mTxtSensors.append("Sensor name : " + sensor.getName() + "\n");
            mTxtSensors.append("Sensor type : " + sensor.getType() + "\n\n");
        }
    }
}