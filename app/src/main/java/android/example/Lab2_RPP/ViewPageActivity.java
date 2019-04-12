package android.example.Lab2_RPP;

import android.content.Intent;
import android.example.Lab2_RPP.R;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;

public class ViewPageActivity extends MainActivity {

    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Intent intent = getIntent();
        int itererator = intent.getIntExtra("iterator",0);

       viewPager = findViewById(R.id.viewPager);
       Log.d("Tag", "" + arrayList.size());

      ViewPagerAdapter adapter = new ViewPagerAdapter(arrayList, ViewPageActivity.this);
      viewPager.setAdapter(adapter);
      viewPager.setCurrentItem(itererator);
    }
}
