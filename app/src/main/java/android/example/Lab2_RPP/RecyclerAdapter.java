package android.example.Lab2_RPP;

import android.content.Context;
import android.example.Lab2_RPP.R;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHeader> {

  private ArrayList <Element> arrayList;
  private Context context;

    public RecyclerAdapter(ArrayList<Element> arrayList, Context context1) {
        this.arrayList = arrayList;
        this.context = context1;
    }

    @NonNull
    @Override
    public RecyclerAdapter.RecyclerHeader onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        return new RecyclerHeader(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerHeader recyclerHeader, int i) {
        Element object = arrayList.get(i);
        recyclerHeader.descriptionOfTechnology.setText(object.getDescription());
        recyclerHeader.nameOfTechnology.setText(object.getName());
        Glide
                .with(context)
                .load(object.getImage())
                .into(recyclerHeader.Image);
    }

    @Override
    public int getItemCount() {
        return arrayList.size() - 1;
    }

    public class RecyclerHeader extends RecyclerView.ViewHolder {

        ImageView Image;
        TextView nameOfTechnology;
        TextView descriptionOfTechnology;
        public RecyclerHeader(@NonNull View itemView) {
            super(itemView);
            Image = itemView.findViewById(R.id.ImageItem);
            nameOfTechnology=itemView.findViewById(R.id.nameText);
            descriptionOfTechnology = itemView.findViewById(R.id.descriptionText);
        }
    }
}
