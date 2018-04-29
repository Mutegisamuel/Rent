package com.example.humungus.rent;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class ListProductsActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    Button addImagebtn;
    ImageView addImage;
    Uri imageUri;
    EditText editTextTitle;
    EditText editTextPrice;
    Button sendButton;
    DatabaseReference propertyDatabase;
    StorageReference propertyStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_products);

//        initialize the database and storage
        propertyDatabase = FirebaseDatabase.getInstance().getReference("properties");
        propertyStorage = FirebaseStorage.getInstance().getReference("properties");


//        intialize the views
        editTextTitle = findViewById(R.id.add_title);
        editTextPrice = findViewById(R.id.add_price);
        addImage = findViewById(R.id.ad_image);

//        the buttons
        addImagebtn = findViewById(R.id.addimagebtn);
        sendButton = findViewById(R.id.addpropertybtn);


//        setting a click listener to the addimage button
            addImagebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openfileChooser();
                }
            });

//        set a click listener to the sendbutton
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProperties();
            }
        });
    }

//    this method gets the file extension of our images
    private String getFileExtension(Uri uri){
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

//    adding properties to the database(firebase)
    private void addProperties(){




    }

    private void openfileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){

//            the image uri is used to set an image in the image view and later send it to firebase database
            imageUri = data.getData();

            Glide.with(this)
                    .load(imageUri)
                    .into(addImage);
        }
    }
}
