package com.elgindy.Fitness_App;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.elgindy.Fitness_App.Model.User;

public class HomeActivity extends AppCompatActivity {

    Button button1,button2;
    private TextView tvUser;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        user = (User) getIntent().getSerializableExtra("User");

        tvUser = findViewById(R.id.tvUser);


        if (user != null) {
            tvUser.setText("WELCOME " + user.getUserName());
        }

        button1=findViewById(R.id.startex1);
        button2=findViewById(R.id.startex2);




        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,secondActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,secondActivity2.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.id_logout){
            Intent intent=new Intent(HomeActivity.this,MainActivity.class);
            startActivity(intent);
            return true;
        }
        return true;
    }

    public void easyexersice(View view) {
        Intent intent=new Intent(HomeActivity.this,secondActivity.class);
        startActivity(intent);



    }
    public void hardexersice(View view) {

        Intent intent=new Intent(HomeActivity.this,secondActivity2.class);
        startActivity(intent);


    }


}
