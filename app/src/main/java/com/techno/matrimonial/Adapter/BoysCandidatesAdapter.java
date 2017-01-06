package com.techno.matrimonial.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.techno.matrimonial.R;
import com.techno.matrimonial.Screens.BoysDetailsActivity;

import java.util.ArrayList;

/**
 * Created by arbaz on 2/7/16.
 */
public class BoysCandidatesAdapter extends RecyclerView.Adapter<BoysCandidatesAdapter.MyViewHolder> {
    private ArrayList<String> arrayList;
    Context context;
    View view;
    Button btn_more_info;
    RelativeLayout relativeLayout_boys;
    private SimpleDraweeView circleImage;

    public BoysCandidatesAdapter(ArrayList<String> maincat_list, Context context) {
        this.arrayList = maincat_list;
        this.context = context;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        /*private final Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            ...
        }*/


        public MyViewHolder(View view) {
            super(view);
            relativeLayout_boys= (RelativeLayout) view.findViewById(R.id.layout_boys_more_info);
            circleImage = (SimpleDraweeView) view.findViewById(R.id.boys_profile);
            final Uri imageUri = Uri.parse("http://services.imobbr.com/galeria/78/avatar.png");
            circleImage.setImageURI(imageUri);


            relativeLayout_boys.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent iNext = new Intent(context, BoysDetailsActivity.class);
                    context.startActivity(iNext);
                }
            });
           /* btn_more_info = (Button) view.findViewById(R.id.btn_boys_more_info);
            btn_more_info.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent iNext = new Intent(context, BoysDetailsActivity.class);
                    context.startActivity(iNext);

                }
            });*/
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_boys_candidates, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(BoysCandidatesAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
