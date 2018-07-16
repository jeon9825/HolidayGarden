package org.androidtown.holgabun;


import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ViewUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.nhn.android.maps.overlay.NMapPOIdata;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

public class MainActivity extends AppCompatActivity {


    private ArrayAdapter adapter;
    private Spinner spinner;
    private static final String TAG = "TestActivity";

    AutoScrollViewPager autoViewPager;
    Button button;
    EditText editText;
    int check;
    ArrayList<Garden> Garden = new ArrayList<>();

    org.androidtown.holgabun.GridAdapter adapter2;
    GridView gridView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Garden Information");
        button=(Button)findViewById(R.id.home);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpConnection h=new HttpConnection();
                h.execute("login","minuk","12","12,","hi","bye");
            }
        });

        gridView = (GridView)findViewById(R.id.grid);
        adapter2 = new GridAdapter(this, Garden);


        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        sendtoData();
                    }
                });
            }
        }).start();

        gridView.setAdapter(adapter2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Garden item = (Garden) parent.getItemAtPosition(position) ;

                Intent Serch_i=new Intent(MainActivity.this,Garden_IM.class);
                Serch_i.putExtra("name",item.getName());
                startActivity(Serch_i);
            }
        });

        ArrayList<Integer> data = new ArrayList<>(); //이미지 url를 저장하는 arraylist
        data.add(R.drawable.t1);
        data.add(R.drawable.t2);
        data.add(R.drawable.t3);


        autoViewPager = (AutoScrollViewPager) findViewById(R.id.view_pager);
        AutoScrollAdapter scrollAdapter = new AutoScrollAdapter(this, data);
        autoViewPager.setAdapter(scrollAdapter); //Auto Viewpager에 Adapter 장착
        autoViewPager.setInterval(5000); // 페이지 넘어갈 시간 간격 설정
        autoViewPager.startAutoScroll(); //Auto Scroll 시작

        spinner = (Spinner) findViewById(R.id.si);
        adapter = ArrayAdapter.createFromResource(this, R.array.si_do, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                check = position;
                switch (position) {
                    case 8:
                        spinner = (Spinner) findViewById(R.id.gu);
                        adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.Gung_si, android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(adapter);
                        break;
                    default:
                        spinner = (Spinner) findViewById(R.id.gu);
                        adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.not, android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(adapter);


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button = (Button) findViewById(R.id.search_bun);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Search.class);
                intent.putExtra("si", check);
                editText = (EditText) findViewById(R.id.tutname);
                try {
                    intent.putExtra("name", editText.getText().toString());
                } catch (NullPointerException e) {
                    intent.putExtra("name", "없음");
                }
                startActivity(intent);
            }
        });


    }


    public void onClickedTimeLine(View v){
        Intent intent = new Intent(this, TimeLine.class);
        startActivity(intent);
    }

    public void onClickedLogin(View v){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


    public void sendtoData() {

        HttpConnection h = new HttpConnection();
        String body = null;

        try {
            int markerId = NMapPOIflagType.PIN;
            body = h.execute("Random").get();
            // String 으로 들어온 값 JSONObject 로 1차 파싱
            JSONObject wrapObject = new JSONObject(body);
            wrapObject = new JSONObject(wrapObject.getString("Grid_20171122000000000552_1"));
            Log.d(TAG, body);
            // JSONObject 의 키 "list" 의 값들을 JSONArray 형태로 변환
            JSONArray jsonArray = new JSONArray(wrapObject.getString("row"));


            // set POI data

            for (int i = 0; i <4; i++) {
                // Array 에서 하나의 JSONObject 를 추출
                JSONObject dataJsonObject = jsonArray.getJSONObject(i);
                // 추출한 Object 에서 필요한 데이터를 표시할 방법을 정해서 화면에 표시

                Garden.add(new Garden(dataJsonObject.getString("FARM_NM"), BitmapFactory.decodeResource(getResources(),R.drawable.icon),dataJsonObject.getString("ADDRESS1")));

            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }



}
