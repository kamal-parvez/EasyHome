package com.example.username.easyhome;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostActivity extends AppCompatActivity {

    private EditText name;
    private EditText phn;

    //private CheckBox nego;
    private Button post;

   // private String strDes;
    //private String strRent;
    private String strName;
    private String strPhn;
    //private String strnego;

    private String str;

    DatabaseReference databaseAd;

    //extra


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        //ex
        //storage = FirebaseStorage.getInstance();
        //storageReference = storage.getReference();

        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            str = extras.getString("KEY");
        }
       // Toast.makeText(this, str , Toast.LENGTH_LONG).show();

        name = (EditText) findViewById(R.id.name);
        phn = (EditText) findViewById(R.id.phone);

        //nego = (CheckBox) findViewById(R.id.negotiable);
        post = (Button) findViewById(R.id.post);

//        if(nego.isChecked()){
//            strnego = "Negotiable";
//        }
//        else{
//            strnego = "Not Negotiable";
//        }


        final String[] data = str.split("---");

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strName = name.getText().toString();
                strPhn = phn.getText().toString();
                PostInfo flatInfo = new PostInfo(strName, strPhn, data[0], data[1], data[2], data[3], data[4], data[5], data[6],
                                                data[7],data[8], data[9], data[10],data[11]);
                databaseAd = FirebaseDatabase.getInstance().getReference("Ad");
                String id = databaseAd.push().getKey();
                databaseAd.child(id).setValue(flatInfo).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {

                            Toast.makeText(PostActivity.this,"Stored",Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(PostActivity.this,"Error",Toast.LENGTH_SHORT).show();
                    }
                });

                Intent intent = new Intent(PostActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}


/*private StorageReference storageReference;
    private FirebaseStorage storage;
    private static final int GALLERY_INTENT = 2;
    private ProgressBar progressBar;


    private Uri filepath ;
    private final int PICK_IMAGE_REQUEST = 71;



add.setOnClickListener(new View.OnClickListener() {
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
@Override
public void onClick(View view) {
        //add photo here
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        //startActivityForResult(intent, GALLERY_INTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);

        }
        });



      private void uploadImage(){
        if(filepath != null){
            final ProgressDialog dialog = new ProgressDialog(Post1.this);
            dialog.setTitle("Uploading...");
            dialog.show();

            StorageReference ref = storageReference.child("Images/" + UUID.randomUUID().toString());

            ref.putFile(filepath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    dialog.dismiss();
                    Toast.makeText(Post1.this, "Upload Done", Toast.LENGTH_SHORT).show();
                    //progressBar.dismiss();
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            dialog.dismiss();
                            Toast.makeText(Post1.this, "Upload Failed" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                            dialog.setMessage("Uploaded " + (int)progress + "%");
                        }
                    });

        }
    }



       @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null){

           // progressBar.setMessage("Uploading....");
            //progressBar.show();

            filepath = data.getData();
            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),filepath);
                imageButton.setImageBitmap(bitmap);
            }
            catch (IOException e){
                e.printStackTrace();
            }
//            StorageReference filepath = storageReference.child("Image").child(uri.getLastPathSegment());
//
//            filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                    Toast.makeText(Post1.this, "Upload Done", Toast.LENGTH_SHORT).show();
//                    //progressBar.dismiss();
//                }
//            });
        }
    }



//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(resultCode == GALLERY_INTENT && resultCode == RESULT_OK){
//
//           // progressBar.setMessage("Uploading....");
//            //progressBar.show();
//
//            Uri uri = data.getData();
//            StorageReference filepath = storageReference.child("Image").child(uri.getLastPathSegment());
//
//            filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                    Toast.makeText(Post1.this, "Upload Done", Toast.LENGTH_SHORT).show();
//                    //progressBar.dismiss();
//                }
//            });
//        }
//    }

*/