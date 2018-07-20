package org.androidtown.holgabun;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.nhn.android.maps.nmapdata.j;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.ResourceBundle;


public class Tab_fragment2_Search_Account extends AppCompatActivity {

    private static final String TAG = "TestActivity";
    EditText editText;
    TextView textView;
    Spinner spinner;
    Adapter adapter;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_fragment2_search_account);
        editText=(EditText)findViewById(R.id.search_id);
        editText=(EditText)findViewById(R.id.search_answer);
        spinner=(Spinner)findViewById(R.id.search_question);

        spinner=(Spinner)findViewById(R.id.search_question);
        adapter = ArrayAdapter.createFromResource(this, R.array.search_question, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) adapter);
    }

    public void onClickedID(View v){
        Intent intent = new Intent(Tab_fragment2_Search_Account.this, Tab_fragment1_Search_Account.class);
        startActivity(intent);
        finish();
    }

    private void loginFunc(){
        class LoginAsync extends AsyncTask<String,Void,String> {

            ProgressDialog loading;
            RequestHandler rh = new RequestHandler();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Tab_fragment2_Search_Account.this, "Uploading...", null,true,true);
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);


                try {
                    JSONObject j=new JSONObject(s);
                    if(j.getString("PWD").equlas("true");
                         { // JSONObject 추출
                            button=(Button)findViewById(R.id.su);
                            button.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(Tab_fragment2_Search_Account.this, Change_Password.class);
                                    startActivity(intent);
                                }
                                }
                        } else {

                            Toast.makeText(Tab_fragment2_Search_Account.this, s, Toast.LENGTH_LONG).show();
                        }



                 catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (JSONException e) {
                    e.printStackTrace();
                }


                @Override
            protected String doInBackground(String... params) {



                HashMap<String,String> data = new HashMap<>();
                editText=(EditText)findViewById(R.id.search_id);
                data.put("ID",editText.getText().toString());
                data.put("QUEST",spinner.getSelectedItem().toString());
                editText=(EditText)findViewById(R.id.search_answer);
                data.put("AW",editText.getText().toString());


                String result = rh.sendPostRequest("http://ec2-13-209-68-163.ap-northeast-2.compute.amazonaws.com/getPWD.php",data);

                Log.d(TAG,result);

                try{
                    JSONObject j=new JSONObject(result);

                    return j.getString("result");


                }catch(JSONException e){
                    e.printStackTrace();
                    return "";
                }


            }
        }

        LoginAsync ui = new LoginAsync();
        ui.execute("");
    }
}


