package com.example.android.tflitecamerademo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    CostumPagerAdapter mCustomPagerAdapter;
    ViewPager mViewPager;
    int mImage[] = {
            R.drawable.daisy,
            R.drawable.dandelion,
            R.drawable.roses,
            R.drawable.sunflowers,
            R.drawable.tulips,

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mCustomPagerAdapter = new CostumPagerAdapter(MainActivity.this, mImage);
        mViewPager.setAdapter(mCustomPagerAdapter);

        CardView cardViewFlower = (CardView) findViewById(R.id.cvFlowers);
        cardViewFlower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FlowersActivity.class);
                startActivity(i);
            }
        });

        CardView cardViewScan = (CardView) findViewById(R.id.cvScan);
        cardViewScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(i);
            }
        });

        CardView cardViewQuit = (CardView)findViewById(R.id.cvQuit);
        cardViewQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Anda yakin ingin keluar ?");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog quit = builder.create();
                quit.show();
            }
        });
    }
}
