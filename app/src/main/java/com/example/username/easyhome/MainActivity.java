package com.example.username.easyhome;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private SearchView search;

    DatabaseReference databaseReference;
    ListView listView;
    List<PostInfo> list;
   // HashMap<PostInfo, String> map;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getFragmentManager();
            switch (item.getItemId()) {

                case R.id.navigation_home:
                    mTextMessage.setText("");
                    return true;

                case R.id.navigation_login:
                    //mTextMessage.setText("Login");
                    Intent intent1 = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent1);
                    //fragmentManager.beginTransaction()
                           // .replace(R.id.navigation_login, new FirstFragment())
                           // .commit();
                    return true;

                case R.id.navigation_my_account:
                    mTextMessage.setText("");
                    return true;
                case R.id.navigation_post_ad:
                    mTextMessage.setText("");
                    Intent intent2 = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent2);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        mTextMessage.setText("");
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        search = (SearchView) findViewById(R.id.search);
        list = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("Ad");
        listView = (ListView) findViewById(R.id.list);
        //map = new HashMap<>();


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Location.class);
                intent.putExtra("KEY","Search");
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference = FirebaseDatabase.getInstance().getReference("Ad");
        listView = (ListView) findViewById(R.id.list);

        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot AdSnapshot : dataSnapshot.getChildren()) {
                    PostInfo flatInfo = AdSnapshot.getValue(PostInfo.class);
                   // String key = AdSnapshot.getKey().toString();
                    list.add(flatInfo);
                   // map.put(flatInfo, key);
                }
                AdList adapter = new AdList(MainActivity.this, list);
                listView.setAdapter(adapter);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
