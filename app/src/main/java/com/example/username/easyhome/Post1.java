package com.example.username.easyhome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Post1 extends AppCompatActivity {

    private Spinner renter;
    private Spinner area;

    private EditText title;
    private EditText rent;
    private EditText size;
    private Button next;
    //private TextView cat;

    private String strCatDiv;
    private String strArea;
    private String strRenter;
    private String strSize;
    private String strRent;
    private String strTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post1);

        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            strCatDiv = extras.getString("KEY");
        }


        next = (Button) findViewById(R.id.next);
        //cat = (TextView) findViewById(R.id.cat);


        renter = (Spinner) findViewById(R.id.renter);
        area = (Spinner) findViewById(R.id.area);

        title = (EditText) findViewById(R.id.title);
        rent = (EditText) findViewById(R.id.rent);
        size = (EditText) findViewById(R.id.size);


        //For next page
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strArea = area.getSelectedItem().toString();
                strRenter = renter.getSelectedItem().toString();

                strTitle = title.getText().toString();
                strSize = size.getText().toString();
                strRent = rent.getText().toString();

                String str = strCatDiv + "---" + strArea + "---" + strRenter+ "---" + strTitle + "---" + strRent+ "---" + strSize ;
                Intent intent = new Intent(Post1.this, Post2.class);
                intent.putExtra("KEY",str);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        String[] data = strCatDiv.split("---");

        findDistrict(data[1]);
        findRenter();
    }







    private void findRenter(){
        String[] items = new String[]{"Family", "Bachelor", "Both"};

        ArrayAdapter<String> adapterDistrict = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        renter.setAdapter(adapterDistrict);
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

    }
}
