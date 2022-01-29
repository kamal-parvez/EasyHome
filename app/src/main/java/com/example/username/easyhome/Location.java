package com.example.username.easyhome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Location extends AppCompatActivity {

    private Button dhaka;
    private Button raj;
    private Button chat;
    private Button khulna;
    private Button sylhet;
    private Button rangpur;
    private Button bari;
    private Button mymen;
    private Button dhakaDiv;
    private Button rajDiv;
    private Button chatDiv;
    private Button khulnaDiv;
    private Button sylhetDiv;
    private Button rangpurDiv;
    private Button bariDiv;
    private Button mymenDiv;

    private TextView cat;

    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location);

        cat = (TextView) findViewById(R.id.category);

        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            type = extras.getString("KEY");
        }


        if(type.equals("Search")){
            cat.setText("Search by City/Division");
        }
        else {
            cat.setText("Post Your Ad");
        }


        dhaka = (Button) findViewById(R.id.dhaka);
        raj = (Button) findViewById(R.id.rajshahi);
        chat = (Button) findViewById(R.id.chattagram);
        khulna = (Button) findViewById(R.id.khulna);
        sylhet = (Button) findViewById(R.id.sylhet);
        rangpur = (Button) findViewById(R.id.rangpur);
        bari = (Button) findViewById(R.id.barishal);
        mymen = (Button) findViewById(R.id.mymensingh);
        dhakaDiv = (Button) findViewById(R.id.dhakaDiv);
        rajDiv = (Button) findViewById(R.id.rajDiv);
        chatDiv = (Button) findViewById(R.id.chattaDiv);
        khulnaDiv = (Button) findViewById(R.id.khulnaDiv);
        sylhetDiv = (Button) findViewById(R.id.sylhetDiv);
        rangpurDiv = (Button) findViewById(R.id.rangpurDiv);
        bariDiv = (Button) findViewById(R.id.barishalDiv);
        mymenDiv = (Button) findViewById(R.id.mymenDiv);

        click(dhaka);
        click(raj);
        click(chat);
        click(khulna);
        click(sylhet);
        click(rangpur);
        click(bari);
        click(mymen);
        click(dhakaDiv);
        click(rajDiv);
        click(chatDiv);
        click(khulnaDiv);
        click(sylhetDiv);
        click(rangpurDiv);
        click(bariDiv);
        click(mymenDiv);
    }

    private void click(final Button btn){

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String div = btn.getText().toString();

                Intent intent1 = new Intent(Location.this, Post1.class);
                Intent intent2 = new Intent(Location.this, SearchActivity.class);

               if(type.equals("Search")){
                    intent2.putExtra("KEY",div);
                   intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent2);
               }
                else {
                    intent1.putExtra("KEY",type + "---" + div );
                    intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent1);
                }


            }
        });
    }
}
