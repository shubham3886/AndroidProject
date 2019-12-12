package com.example.sistec_event;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_Home_Acivity extends AppCompatActivity {
    Button b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__home__acivity);

        b4 = findViewById(R.id.view);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PostList.class);
                startActivity(intent);
            }
        });


    }
    public void addNewUser(View view) {
        Intent intent = new Intent(this, Add_Event.class);
        startActivity(intent);
    }

    public void viewUsers(View view) {
        Intent intent = new Intent(this, View_All_Users.class);
        startActivity(intent);
    }
}
