package org.androidtown.holgabun;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;


public class Tab_fragment2_Search_Account extends AppCompatActivity {

    private ArrayAdapter adapter;
    private Spinner spinner;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_fragment2_search_account);

        spinner = (Spinner) findViewById(R.id.Question);
        adapter = ArrayAdapter.createFromResource(this, R.array.Question, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }



    public void onClickedID(View v){
        Intent intent = new Intent(this, Tab_fragment1_Search_Account.class);
        startActivity(intent);
        finish();
    }

    public void onClickedPW(View v){
        Intent intent = new Intent(this, Tab_fragment2_Search_Account.class);
        startActivity(intent);
        finish();
    }

    public void onClickedButton(View v){
        Intent intent = new Intent(this, Change_Password.class);
        startActivity(intent);
    }

}


