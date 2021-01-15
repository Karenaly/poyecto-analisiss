package com.example.shitagain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    public static String Nombre, Correo;
    private Button btning;
    private TextView txtpueba;
    private EditText txtcorreo,txtcontra;
    RequestQueue requestQueue;
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtpueba = (TextView) findViewById(R.id.txtprueba);
        btning = (Button) findViewById(R.id.btning);

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        btning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postData();
                Clickbut(v);
            }
        });
    }

    public void  Clickbut(View view){
        NavDrawerr.redirecActivity(this,NavDrawerr.class);
    }
    public void postData() {
        txtcorreo=(EditText)findViewById(R.id.txtcorreo);
        txtcontra=(EditText)findViewById(R.id.txtcontra);
            String url = "http://servidorisaac.us-west-1.elasticbeanstalk.com/empleados/getusuario";
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
                            txtpueba.setText("Datos del usuario:" + response.toString());
                            parseData(response);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("correo", txtcorreo.toString());
                    params.put("contra", txtcontra.toString());

                    return params;
                }

            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
    }

    public void parseData(String response) {

        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString("status").equals("true")) {
                JSONArray dataArray = jsonObject.getJSONArray("id_usuarios");
                for (int i = 0; i < dataArray.length(); i++) {

                    JSONObject dataobj = dataArray.getJSONObject(i);
                    Nombre = dataobj.getString("name");
                    Correo = dataobj.getString("hobby");
                }

                Intent intent = new Intent(MainActivity.this,NavDrawerr.class);
                startActivity(intent);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}