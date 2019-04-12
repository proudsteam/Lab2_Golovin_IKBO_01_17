package android.example.Lab2_RPP;

import android.content.Intent;
import android.example.Lab2_RPP.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Element> arrayList;
    ListView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.myRecycler);
        ListAdapter adapter = new ListAdapter(arrayList,MainActivity.this);
        recyclerView.setAdapter(adapter);
        String jsonFile = loadJSONFromAsset();
        String helptext;
        try {
            JSONArray jsonArray = new JSONArray(jsonFile);
            Log.d("Tag", "" +jsonArray.length());
            for (int i=1; i < jsonArray.length(); i++)
            {
                Log.d("Tag","Iteration " + i);
                JSONObject jsonObject = new JSONObject();
                Log.d("Tag","FLAG0");
                jsonObject = jsonArray.getJSONObject(i);
                Log.d("Tag","FLAG0.1");
                Log.d("Tag", "" + jsonObject.has("flags"));
                Log.d("Tag",jsonObject.getString("name"));
                if (jsonObject.has("flags"))
                    helptext = "no description";
                else helptext = jsonObject.getString("helptext");
                Log.d("Tag","FLAG0.2");
                Log.d("Tag", " flag1");
                arrayList.add(new Element(jsonObject.getString("name"),helptext,jsonObject.getString("graphic")));
                Log.d("Tag","flag2");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, ViewPageActivity.class);
                intent.putExtra("iterator",i);
                startActivity(intent);

            }
        });
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("JSON.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }
}


