package android.example.Lab2_RPP;

import android.content.Context;
import android.example.Lab2_RPP.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    private ArrayList<Element> arrayList;
    private Context context;
    ImageView Image;
    TextView NameOfTechnology;
    TextView DescriptionOfTechnology;

    public ListAdapter(ArrayList<Element> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;

    }

    @Override
    public int getCount() {
        return arrayList.size()-1;
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater lInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View View = view;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, viewGroup, false);
        }
        Image = view.findViewById(R.id.ImageItem);
        NameOfTechnology=view.findViewById(R.id.nameText);
        DescriptionOfTechnology = view.findViewById(R.id.descriptionText);
        Element object = arrayList.get(i);
        DescriptionOfTechnology.setText(object.getDescription());
        NameOfTechnology.setText(object.getName());
        Glide
                .with(context)
                .load(object.getImage())
                .into(Image);
        return view;
    }
}
