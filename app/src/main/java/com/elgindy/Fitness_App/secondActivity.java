package com.elgindy.Fitness_App;

import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class secondActivity extends AppCompatActivity {

    int[] newArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);



        newArray = new int[]{

                R.id.ex1,R.id.ex2,R.id.ex3,R.id.ex4,R.id.ex5,R.id.ex6,R.id.ex7,R.id.ex8,R.id.ex9,R.id.ex10,R.id.ex11,R.id.ex12,R.id.ex13,R.id.ex14,R.id.ex15,



        };
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
            Intent intent=new Intent(secondActivity.this,MainActivity.class);
            startActivity(intent);
            return true;
        }
        return true;
    }

    public void Imagebuttonclicked(View view) {

        for (int i=0;i<newArray.length;i++){

            if(view.getId() == newArray[i]){
                int value=i+1;

                Log.i("FIRST",String.valueOf(value));
                Intent intent =new Intent(secondActivity.this, ThirdActivity.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);
            }

        }

    }

}