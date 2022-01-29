package com.example.username.easyhome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Post2 extends AppCompatActivity {

    private Button next;
    //private Button prev;

    private Spinner bed;
    private Spinner bath;
    private Spinner features;

    private EditText description;
    private EditText address;

    private String str;
    private String strBed;
    private String strBath;
    private String strFeatures;
    private String strDes;
    private String strAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post2);

        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            str = extras.getString("KEY");
        }

        //Toast.makeText(this, str , Toast.LENGTH_LONG).show();
        //Toast.makeText(this, flatInfo.getArea(), Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, flatInfo.getRenter(), Toast.LENGTH_SHORT).show();

        next = (Button)findViewById(R.id.next);
        //prev = (Button)findViewById(R.id.prev);

        bed = (Spinner) findViewById(R.id.bed);
        bath = (Spinner) findViewById(R.id.bath);
        features = (Spinner) findViewById(R.id.features);

        description = (EditText) findViewById(R.id.des);
        address = (EditText) findViewById(R.id.address);

        findBed();
        findBath();
        findFeatures();

        nextClick();
       // prevClick();
    }

    private void findBed(){
        String[] items = new String[]{"1", "2", "3", "4", "5", "6", "7+"};
        ArrayAdapter<String> adapterDivision = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        bed.setAdapter(adapterDivision);
    }

    private void findBath(){
        String[] items = new String[]{"1", "2", "3", "4", "5", "6", "7+"};
        ArrayAdapter<String> adapterDivision = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        bath.setAdapter(adapterDivision);
    }

    private void findFeatures(){
        String[] items = new String[]{"Full-Furnished", "Semi-Furnished", "not-Furnished"};
        ArrayAdapter<String> adapterDivision = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        features.setAdapter(adapterDivision);
    }




    private void nextClick(){
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strBed = bed.getSelectedItem().toString();
                strFeatures = features.getSelectedItem().toString();
                strBath = bath.getSelectedItem().toString();
                strDes = description.getText().toString();
                strAddress = address.getText().toString();

                str = str+ "---" + strBed + "---" + strBath + "---" + strFeatures + "---" + strAddress+ "---" + strDes ;

                Intent intent = new Intent(Post2.this, PostActivity.class);
                intent.putExtra("KEY",str);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });
    }

//    private void prevClick(){
//        prev.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Post2.this, Post1.class);
//                startActivity(intent);
//            }
//        });
//    }
}
