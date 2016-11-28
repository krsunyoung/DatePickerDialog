package com.bit2016.datepickerdialog;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;

public class DatePickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);

        ((DatePicker)findViewById(R.id.datePicker)).init(2016, 11, 28, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Intent intent = new Intent();
                intent.putExtra("year", year);
                intent.putExtra("monthOfYear", monthOfYear+1);
                intent.putExtra("dayOfMonth", dayOfMonth);

                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }

    //백버튼 override
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        setResult(Activity.RESULT_CANCELED, null);
        finish();
    }
}
