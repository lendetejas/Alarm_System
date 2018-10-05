package alarm_clock.com.alarm_clock;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int seconds;
    private RecyclerView recyclerView;
    private Adapter adapter;
     ArrayList<GetDataList>  getDataLists;
    //private List<GetDataList> getDataLists;
    private FloatingActionButton fab;
   static String datestr = "Date";
    static String    timestr= "Time";
    static String    titlestr= "Title";
    static String   highstr= "Switch1";
    static String    mstr= "Switch2";
    static String    lowstr= "Switch3";
    Switch High_Switch,Medium_Switch,Low_Switch;
    TextView datepicker,titletxt, textView;
    String StringTitle;
    static String strDate = "";
    Date  date;
    String formattedDate;
    String Timestr;
    StringBuffer strBuffer,strBuffer1;
    RelativeLayout relativeLayout;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDataLists = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GetDataList dataList1 = new GetDataList(datestr.trim(), timestr.trim(), titlestr.trim());
        getDataLists.add(dataList1);
        //adapter.notifyDataSetChanged();

        setRecyclerViewData(); //adding data to array list
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new Adapter(this, getDataLists);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab);



        View view = getLayoutInflater().inflate(R.layout.activity_set__alarm,null);
        dialog = new Dialog(this, android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
        dialog.setContentView(view);

        relativeLayout = view.findViewById(R.id.relayout);


        fab.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Set_Alarm.class);
               startActivity(intent);

            }
        });


        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {

                datestr = "Date";
                  timestr= "Time";
                    titlestr= "Title";
                  highstr= "Switch1";
                   mstr= "Switch2";
                 lowstr= "Switch3";
            } else {
                datestr = extras.getString("DATE");
                timestr = extras.getString("TIME");
                titlestr = extras.getString("TITLE");
                highstr = extras.getString("PRIORITY");
                mstr = extras.getString("PRIORITY1");
                lowstr = extras.getString("PRIORITY2");

                GetDataList dataList = new GetDataList(datestr.trim(), timestr.trim(), titlestr.trim());
                Log.d("", "strDate2121" + datestr);
                Log.d("", "Timestr1212" + timestr);
                Log.d("", "StringTitle122" + titlestr);
                Log.d("", "HighCheck1212" + highstr);
                Log.d("", "MCheck1212" + mstr);
                Log.d("", "LowCheck1212" + lowstr);
                getDataLists.add(dataList);
                //adapter.notifyDataSetChanged();
                adapter = new Adapter(this, getDataLists);
                recyclerView.setAdapter(adapter);
                //notify data set changed in RecyclerView adapter

            }
        } else {
            datestr = (String) savedInstanceState.getSerializable("DATE");
            timestr = (String) savedInstanceState.getSerializable("TIME");
            titlestr = (String) savedInstanceState.getSerializable("TITLE");
            highstr = (String) savedInstanceState.getSerializable("PRIORITY");
            mstr = (String) savedInstanceState.getSerializable("PRIORITY1");
            lowstr = (String) savedInstanceState.getSerializable("PRIORITY2");

        }
        Log.d("", "strDate2121" + datestr);
        Log.d("", "Timestr1212" + timestr);
        Log.d("", "StringTitle122" + titlestr);
        Log.d("", "HighCheck1212" + highstr);
        Log.d("", "MCheck1212" + mstr);
        Log.d("", "LowCheck1212" + lowstr);



        //adding new object to arraylist








        }


    private void setRecyclerViewData() {
      //  getDataLists.add(new GetDataList("06-oct-18", "08:02:11","Android"));

    }


}


