package com.cookandroid.crono;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Chronometer chrono;
    //Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;
    CalendarView calView;
    TimePicker tPicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    DatePicker DatePicker1 ;
    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //    btnStart = (Button) findViewById(R.id.btnStart);
      //  btnEnd = (Button) findViewById(R.id.btnEnd);
        chrono = (Chronometer) findViewById(R.id.chronometer1);
        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);
        //calView = (CalendarView) findViewById(R.id.calendarView1);
        tPicker = (TimePicker)findViewById(R.id.timePicker1);
        tvYear = (TextView)findViewById(R.id.tvYear);
        tvMonth = (TextView)findViewById(R.id.tvMonth);
        tvDay = (TextView)findViewById(R.id.tvDay);
        tvHour = (TextView)findViewById(R.id.tvHour);
        tvMinute = (TextView)findViewById(R.id.tvMinute);
        DatePicker1 = (DatePicker) findViewById(R.id.DatePicker1);
        tPicker.setVisibility(View.INVISIBLE);
       // calView.setVisibility(View.INVISIBLE);
        rdoTime.setVisibility(View.INVISIBLE);
        rdoCal.setVisibility(View.INVISIBLE);
        DatePicker1.setVisibility(View.INVISIBLE);

        chrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
                rdoCal.setVisibility(View.VISIBLE);
                rdoTime.setVisibility(View.VISIBLE);
            }
        });

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tPicker.setVisibility(View.INVISIBLE);
                DatePicker1.setVisibility(View.VISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tPicker.setVisibility(View.VISIBLE);
                DatePicker1.setVisibility(View.INVISIBLE);
            }
        });


       /* btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });*/

       tvYear.setOnLongClickListener(new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View view) {
               chrono.stop();
               chrono.setTextColor(Color.BLUE);

               java.util.Calendar curDate = java.util.Calendar.getInstance();
              // curDate.setTimeInMillis(calView.getDate());

               tvYear.setText(Integer.toString(curDate.get(Calendar.YEAR)));
               tvMonth.setText(Integer.toString(curDate.get(Calendar.MONTH)));
               tvDay.setText(Integer.toString(curDate.get(Calendar.DATE)));

               /*tvYear.setText(Integer.toString(curDate.get(Calendar.YEAR)));
               tvMonth.setText(Integer.toString(1+curDate.get(Calendar.MONTH)));
               tvDay.setText(Integer.toString(curDate.get(Calendar.DATE)));*/
               tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
               tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));
               rdoCal.setVisibility(View.INVISIBLE);
               rdoTime.setVisibility(View.INVISIBLE);
               tPicker.setVisibility(View.INVISIBLE);
               DatePicker1.setVisibility(View.INVISIBLE);
               return false;
           }
       });

       /* btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);
                 java.util.Calendar curDate = java.util.Calendar.getInstance();
        curDate.setTimeInMillis(calView.getDate());
        tvYear.setText(Integer.toString(curDate.get(Calendar.YEAR)));
        tvMonth.setText(Integer.toString(1+curDate.get(Calendar.MONTH)));
        tvDay.setText(Integer.toString(curDate.get(Calendar.DATE)));
        tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
        tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));
            }
        });*/


    }
}
