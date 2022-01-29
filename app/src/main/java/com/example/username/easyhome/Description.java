package com.example.username.easyhome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class Description extends AppCompatActivity {

    DatabaseReference databaseReference;
    PostInfo details;
    private String info;

    private TextView title;
    private TextView rent;
    private TextView location;
    private TextView type;
    private TextView category;
    private TextView bed;
    private TextView bath;
    private TextView size;
    private TextView features;
    private TextView description;
    private TextView name;
    private TextView contact;
    private TextView address;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        title = (TextView) findViewById(R.id.title);
        rent = (TextView) findViewById(R.id.rent);
        location = (TextView) findViewById(R.id.area);
        type = (TextView) findViewById(R.id.type);
        size = (TextView) findViewById(R.id.size);
        bed = (TextView) findViewById(R.id.bed);
        bath = (TextView) findViewById(R.id.bath);
        category = (TextView) findViewById(R.id.category);

        address = (TextView) findViewById(R.id.address);
        contact = (TextView) findViewById(R.id.contact);
        name = (TextView) findViewById(R.id.name);
        features = (TextView) findViewById(R.id.features);
        description = (TextView) findViewById(R.id.description);

        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            info = extras.getString("KEY");
        }

       // getData();
        makeDetails();
    }

    private void makeDetails(){
        final String[] data = info.split("---");

        title.setText("            " + data[0]);
        bed.setText("Bed: " + data[1]);
        bath.setText("Bath: " + data[2]);

        size.setText("Size: " + data[3]);
        rent.setText("Rent: " + data[4]);
        location.setText("Location: " + data[6] +", "+ data[5]);

        type.setText("Renter Type: " + data[7]);
        address.setText("Address: " + data[8]);
        description.setText("Description: " + data[9]);

        features .setText("Features: " + data[10]);
        name .setText("Name: " + data[11]);
        contact .setText("Contact: " + data[12]);
        category.setText("Category: " + data[13]);

    }

//    flatInfo.getTitle() + "---" + flatInfo.getBed() + "---" + flatInfo.getBath() + "---"
//            + flatInfo.getSize() + "---" + flatInfo.getRent() + "---" +flatInfo.getDivision() + "---"
//            + flatInfo.getArea() + "---" + flatInfo.getRenter() + "---" + flatInfo.getAddress() + "---"
//            + flatInfo.getDescription() + "---" + flatInfo.getFeatures() + "---" + flatInfo.getName() + "---"
//            + flatInfo.getPhn() + "---" + flatInfo.getInNego();

//    private void getData(){
//        databaseReference = FirebaseDatabase.getInstance().getReference("Ad");
//
//        databaseReference.addValueEventListener(new ValueEventListener() {
//
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot AdSnapshot : dataSnapshot.getChildren()) {
//                    PostInfo flatInfo = AdSnapshot.getValue(PostInfo.class);
//                    String str = AdSnapshot.getKey().toString();
//
//                    if(key.equals(str)){
//                        details = flatInfo;
//                        break;
//                    }
//                }
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//    }
}
