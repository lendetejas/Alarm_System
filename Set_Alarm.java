package alarm_clock.com.alarm_clock;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Set_Alarm extends AppCompatActivity {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int seconds;
    TextView datepicker,titletxt, textView;
    String StringTitle;
    static String strDate = "";
    Date  date;
    String formattedDate;
    String Timestr;
    StringBuffer strBuffer,strBuffer1;
    Switch High_Switch,Medium_Switch,Low_Switch;
    String HighCheck,MCheck,LowCheck;
    Button save_btn,cancel_btn;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set__alarm);




        datepicker = findViewById(R.id.datepicker);
        titletxt = findViewById(R.id.title_name);
         textView = (TextView)findViewById(R.id.textViewShowDateTime);
        High_Switch = findViewById(R.id.switch_highbtn);
        Medium_Switch = findViewById(R.id.switch_mbtn);
        Low_Switch = findViewById(R.id.switch_lowbtn);
        save_btn = findViewById(R.id.save_btn);
        cancel_btn = findViewById(R.id.cancel_btn);
        // Get current calendar date and time.
        Calendar currCalendar = Calendar.getInstance();

        // Set the timezone which you want to display time.
        currCalendar.setTimeZone(TimeZone.getTimeZone("Asia/India"));

        year = currCalendar.get(Calendar.YEAR);
        month = currCalendar.get(Calendar.MONTH);
        day = currCalendar.get(Calendar.DAY_OF_MONTH);
        hour = currCalendar.get(Calendar.HOUR_OF_DAY);
        minute = currCalendar.get(Calendar.MINUTE);
        seconds = currCalendar.get(Calendar.SECOND);

      showUserSelectDateTime();


        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
         formattedDate = df.format(c);

        textView.setText(formattedDate);
        Log.d("date", " efsf223424 " + formattedDate);


        High_Switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Medium_Switch.setChecked(false);
                Low_Switch.setChecked(false);
            }
        });

        Medium_Switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                High_Switch.setChecked(false);
                Low_Switch.setChecked(false);
            }
        });

        Low_Switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Medium_Switch.setChecked(false);
                High_Switch.setChecked(false);
            }
        });




        datepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DatePickerDialog dialog = DatePickerDialog.newInstance(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                         strDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        Log.d("date", " date121212 " + strDate);


                        try {
                            date = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                         formattedDate = new SimpleDateFormat("dd MMM yyyy").format(date);
                        Log.d("formattedDate", " formattedDate " + formattedDate);
                        textView.setText(formattedDate);
                        textView.setTextColor(Color.BLUE);
                        textView.setGravity(Gravity.CENTER);
                        textView.setTextSize(20);
                        Log.d("date213", " 11312312313 " + textView);
                    }
                }, year, month, day);

                dialog.show(getFragmentManager(), "DatePickerDialog");



            }
        });


        titletxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Set_Alarm.this);
                alertDialog.setTitle("Title");


                final EditText input = new EditText(Set_Alarm.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);


                alertDialog.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                StringTitle = input.getText().toString();
                               titletxt.setText(StringTitle);
                            }
                        });

                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                alertDialog.show();
            }

        });

        TimePicker timePicker = (TimePicker)findViewById(R.id.timePickerExample);
        timePicker.setHour(this.hour);
        timePicker.setMinute(this.minute);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int minute) {
                Set_Alarm.this.hour = hour;
                Set_Alarm.this.minute = minute;

                showUserSelectDateTime();
            }
        });



        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (High_Switch.isChecked())
                    HighCheck = High_Switch.getTextOn().toString();
                else
                    HighCheck = High_Switch.getTextOff().toString();
                if (Medium_Switch.isChecked())
                    MCheck = Medium_Switch.getTextOn().toString();
                else
                    MCheck = Medium_Switch.getTextOff().toString();
                if (Low_Switch.isChecked())
                    LowCheck = Low_Switch.getTextOn().toString();
                else
                    LowCheck = Low_Switch.getTextOff().toString();
               // Toast.makeText(getApplicationContext(), "Switch1 :" + HighCheck + "\n" + "Switch2 :" + MCheck + "\n" + "Switch3 :" + LowCheck, Toast.LENGTH_LONG).show(); // display the current state for switch's



                if (!High_Switch.isChecked() && (!Medium_Switch.isChecked()) && (!Low_Switch.isChecked())){

                    Toast.makeText(Set_Alarm.this,"Please Select Any One Priority",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(StringTitle)){
                    Toast.makeText(Set_Alarm.this,"Please Enter Title",Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(Set_Alarm.this,MainActivity.class);

                intent.putExtra("DATE", formattedDate);
                intent.putExtra("TIME", Timestr);
                intent.putExtra("TITLE",StringTitle);
                intent.putExtra("PRIORITY",HighCheck);
                intent.putExtra("PRIORITY1",MCheck);
                intent.putExtra("PRIORITY2",LowCheck);

                Log.d("","strDate" + formattedDate);
                Log.d("","Timestr" + Timestr);
                Log.d("","StringTitle" + StringTitle);
                Log.d("","HighCheck" + HighCheck);
                Log.d("","MCheck" + MCheck);
                Log.d("","LowCheck" + LowCheck);


                startActivity(intent);
            }
        });

    }

    /* Show user selected date time in bottom text vew area. */
   private void showUserSelectDateTime()
    {
        // Get TextView object which is used to show user pick date and time.
        TextView textView = (TextView)findViewById(R.id.textViewShowDateTime);

         strBuffer = new StringBuffer();

        strBuffer.append(this.hour);
        strBuffer.append(":");
        strBuffer.append(this.minute);
        strBuffer.append(":");
        strBuffer.append(this.seconds);



        Log.d("","1121324234" + strBuffer);

        Timestr = String.valueOf(strBuffer);

        Log.d("","fsgfwergergerge" + Timestr);
    }
}