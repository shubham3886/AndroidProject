package com.example.sistec_event;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_Event extends AppCompatActivity {
    private EditText etName, etMno, etEmail;
    private DatabaseReference databaseReference;
    private Activity context;
    private ImageView imagePhoto;
    private String photo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__event);
        findViews();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    private void findViews() {
        databaseReference = FirebaseDatabase.getInstance().getReference("Events");
        etEmail = findViewById(R.id.etEmail);
        etMno = findViewById(R.id.etMno);
        etName = findViewById(R.id.etName);
        context = Add_Event.this;
        imagePhoto = findViewById(R.id.photo);
    }

    public void addUser(View view) {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String mno = etMno.getText().toString().trim();

        if (photo != null && !TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(mno)) {
            String uid = databaseReference.push().getKey();
            User user = new User(uid, name, mno, email, photo);
            databaseReference.child(uid).setValue(user);
            Toast.makeText(this, "Event Added", Toast.LENGTH_LONG).show();
            etEmail.setText("");
            etMno.setText("");
            etName.setText("");
        } else {
            Toast.makeText(this, "Please data first!", Toast.LENGTH_LONG).show();
        }
    }

    public void viewUsers(View view) {
        Intent intent = new Intent(this, View_All_Users.class);
        startActivity(intent);
    }

    public void takePhoto(View view) {
        Intent camera = new Intent();
        camera.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera, 111);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111 && data != null) {
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");
            imagePhoto.setImageBitmap(bitmap);
            photo = ImageUtility.BitMapToString(bitmap);
        }
    }
}

