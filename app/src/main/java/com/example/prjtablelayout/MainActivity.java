package com.example.prjtablelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import model.Schedule;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView[] textViewsArr;
    int widgets[] = {R.id.tvMMorning, R.id.tvMAfEv, R.id.tvTMorAft, R.id.tvTEvening};
    Schedule[] scheduleList;
    // some other declarations....

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initialize();
    }

    private void initialize() {
        textViewsArr = new TextView[widgets.length];
        scheduleList = new Schedule[widgets.length];
        scheduleList[0] = new Schedule(0, "Android", Color.MAGENTA);
        scheduleList[1]= new Schedule(1, "ASP.NET", Color.BLUE);
        scheduleList[2] = new Schedule(2, "Java", Color.BLACK);
        scheduleList[3] = new Schedule(3, "ORACLE", Color.RED);
        for (int i =0; i<widgets.length; i++){
            textViewsArr[i] = findViewById(widgets[i]);
            Schedule sch = scheduleList[i];
            textViewsArr[i].setText(sch.getDescription());
            textViewsArr[i].setTextColor(sch.getTxtColor());
            textViewsArr[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
      TextView tvC = (TextView) v;
        Toast.makeText(this,tvC.getText().toString(), Toast.LENGTH_LONG).show();
    }
}