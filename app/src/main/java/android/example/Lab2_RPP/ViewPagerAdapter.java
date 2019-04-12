package android.example.Lab2_RPP;

import android.content.Context;
import android.example.Lab2_RPP.R;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ViewPagerAdapter extends PagerAdapter {
    private ImageView Image;
    private TextView Name;
    private TextView Description;

    private Context context;
    private ArrayList<Element> arrayList;

    public ViewPagerAdapter(ArrayList<Element> arrayList, Context context1) {
        this.arrayList = arrayList;
        this.context = context1;
    }

    @Override
    public int getCount() {
        return arrayList.size() - 1;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater lInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = lInflater.inflate(R.layout.view_page, container, false);
        LinearLayout layoutSlide = (LinearLayout) view.findViewById(R.id.viewPager);
        Image = view.findViewById(R.id.slide_image);
        Name=view.findViewById(R.id.slide_name);
        Description = view.findViewById(R.id.slide_description);
        Element object = arrayList.get(position);
        Description.setText(object.getDescription());
        Name.setText(object.getName());
        Glide
                .with(context)
                .load(object.getImage())
                .into(Image);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == (ConstraintLayout)o);
    }
}
