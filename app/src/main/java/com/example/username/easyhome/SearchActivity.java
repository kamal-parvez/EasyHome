package com.example.username.easyhome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private String strDiv;
    private String strArea;
    private String strRenter;

    private Spinner renter;
    private Spinner area;
    private Button search;

    DatabaseReference databaseReference;
    ListView listView;
    List<PostInfo> list;
    //HashMap<PostInfo, String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            strDiv = extras.getString("KEY");
        }

        renter = (Spinner) findViewById(R.id.type);
        area = (Spinner) findViewById(R.id.area);
        search = (Button) findViewById(R.id.search);

        list = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("Ad");
        listView = (ListView) findViewById(R.id.list);
        //map = new HashMap<>();

        findDistrict(strDiv);
        findRenter();


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeList();
            }
        });

    }

    private void findRenter(){
        String[] items = new String[]{"Family", "Bachelor"};

        ArrayAdapter<String> adapterDistrict = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        renter.setAdapter(adapterDistrict);
        strRenter = renter.getSelectedItem().toString();
    }


    private void findDistrict(String str){

        String[] items = null;

        if(str.equals("Dhaka")){
            items = new String[]{"Mirpur", "Uttra", "Dhanmondi", "Gulshan", "Mohammadpur", "Savar", "Elephant Road",
                    "Jatrabari", "Badda", "Basundhara", "Tejgaon", "Motijheel", "Rampura ", "Banani",
                    "Khilgaon", "Baridhara", "Paltan", "Malibag", "Mogbazar", "Kawranbazar"};
        }
        else if(str.equals("Chattagram")){
            items = new String[]{"Agarbad", "Chawkbazar", "Nasirabad", "Kotwali"};
        }
        else if(str.equals("Khulna")){
            items = new String[]{"Sonadanga", "Rupsa", "Gollamari", "Boyra Bazar"};
        }
        else if(str.equals("Barishal")){
            items = new String[]{"Amtala", "Sadar Road", "Rupatali", "Kalizira" };
        }
        else if(str.equals("Mymensingh")){
            items = new String[]{"Bhaluka", "Trishal", "Phulpur", "Mymensingh Sadar"};
        }
        else if(str.equals("Sylhet")){
            items = new String[]{"South Surma", "Bandar Bazar", "Zinda Bazar", "Shibgonj"};
        }
        else if(str.equals("Rajshahi")) {
            items = new String[]{"Kazla", "Uposahar", "Motihar", "Shiroil"};
        }
        else if(str.equals("Rangpur")){
            items = new String[]{"Dhap", "Modern More", "Bodorgonj", "Shathibari"};
        }

        if(str.equals("Dhaka Division")){
            items = new String[]{"Dhaka", "Faridpur", "Gazipur", "Gopalganj", "Kishoreganj", "Madaripur", "Manikganj",
                    "Munshiganj", "Narayanganj", "Narsingdi", "Rajbari", "Shariatpur", "Tangail "};
        }
        else if(str.equals("Chattagram Division")){
            items = new String[]{"Chattagram", "Bandarban", "Brahmanbaria", "Chandpur", "Cumilla", "Cox's Bazar", "Feni",
                    "Khagrachhari", "Lakshmipur", "Noakhali", "Rangamati" };
        }
        else if(str.equals("Khulna Division")){
            items = new String[]{"Khulna", "Kushtia", "Bagerhat", "Chuadanga", "Jashore", "Jhenaidah", "Magura",
                    "Meherpur", "Narail", "Satkhira"};
        }
        else if(str.equals("Barishal Division")){
            items = new String[]{"Barishal", "Barguna", "Bhola", "Jhalokati", "Patuakhali", "Pirojpur" };

        }
        else if(str.equals("Mymensingh Division")){
            items = new String[]{"Mymensingh", "Jamalpur", "Netrokona", "Sherpur"};

        }
        else if(str.equals("Sylhet Division")){
            items = new String[]{"Sylhet", "Habiganj", "Moulvibazar", "Sunamganj"};

        }
        else if(str.equals("Rajshahi Division")){
            items = new String[]{"Rajshahi", "Bogura", "Chapainawabganj", "Joypurhat", "Naogaon", "Natore", "Pabna", "Mymensingh", "Sirajganj"};
        }
        else if(str.equals("Rangpur Division")){
            items = new String[]{"Rangpur", "Thakurgaon", "Panchagarh", "Nilphamari", "Lalmonirhat", "Kurigram", "Gaibandha", "Dinajpur"};
        }

        ArrayAdapter<String> adapterDistrict = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        area.setAdapter(adapterDistrict);

        strArea = area.getSelectedItem().toString();
    }

    // @Override
//    protected void onStart() {
//        super.onStart();
//
//    }

    private void makeList(){

        strRenter = renter.getSelectedItem().toString();
        strArea = area.getSelectedItem().toString();
        databaseReference = FirebaseDatabase.getInstance().getReference("Ad");
        listView = (ListView) findViewById(R.id.list);

        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot AdSnapshot : dataSnapshot.getChildren()) {
                    PostInfo flatInfo = AdSnapshot.getValue(PostInfo.class);
                    if(flatInfo.getDivision().equals(strDiv) && flatInfo.getArea().equals(strArea) && flatInfo.getRenter().equals(strRenter)){
                        list.add(flatInfo);
                        //String key = AdSnapshot.getKey().toString();
                       // map.put(flatInfo, key);
                    }

                }
                AdList adapter = new AdList(SearchActivity.this, list);
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

}