package org.androidtown.holgabun;

import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentManager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class TimeLine extends AppCompatActivity {

    Button feedButton;
    Button likeButton;
    Button profileButton;
    LinearLayout notice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);
        feedButton = (Button) findViewById(R.id.feedButton);
        likeButton = (Button) findViewById(R.id.likeButton);
        profileButton = (Button) findViewById(R.id.profileButton);
<<<<<<< HEAD
         notice =(LinearLayout) findViewById(R.id.notice);
        notice.setVisibility(View.GONE);
        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,new FeedFragment());
        fragmentTransaction.commit();


=======
        notice = (LinearLayout) findViewById(R.id.notice);
        notice.setVisibility(View.GONE);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, new FeedFragment());
        fragmentTransaction.commit();

>>>>>>> 5e670851b6250999d0fe2e7d131bfec4d502de16

        feedButton.setOnClickListener(new View.OnClickListener() {
            @Override
<<<<<<< HEAD
            public void onClick (View view){
=======
            public void onClick(View view) {
>>>>>>> 5e670851b6250999d0fe2e7d131bfec4d502de16

                feedButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                likeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                profileButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
<<<<<<< HEAD
                FragmentManager fragmentManager =getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment,new FeedFragment());
=======
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new FeedFragment());
>>>>>>> 5e670851b6250999d0fe2e7d131bfec4d502de16
                fragmentTransaction.commit();
            }
        });

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
<<<<<<< HEAD
            public void onClick (View view){
=======
            public void onClick(View view) {
>>>>>>> 5e670851b6250999d0fe2e7d131bfec4d502de16

                feedButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                likeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                profileButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new LikeFragment());
                fragmentTransaction.commit();
            }
        });
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
<<<<<<< HEAD
            public void onClick (View view){
=======
            public void onClick(View view) {
>>>>>>> 5e670851b6250999d0fe2e7d131bfec4d502de16

                feedButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                likeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                profileButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new ProfileFragment());
                fragmentTransaction.commit();
            }
        });
    }

    public void MainClicked(View v){ //메인페이지로 이동
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}