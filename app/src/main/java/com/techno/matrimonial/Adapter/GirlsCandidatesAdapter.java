package com.techno.matrimonial.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.techno.matrimonial.R;
import com.techno.matrimonial.Screens.GirlsDetailsActivity;

import java.util.ArrayList;

/**
 * Created by arbaz on 2/7/16.
 */
public class GirlsCandidatesAdapter extends RecyclerView.Adapter<GirlsCandidatesAdapter.MyViewHolder> {
    private ArrayList<String> arrayList;
    Context context;
    View view;
    Button btn_more_info;
    private SimpleDraweeView circleImage;
    RelativeLayout relativeLayout_girl;

    public GirlsCandidatesAdapter(ArrayList<String> maincat_list, Context context) {
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
            relativeLayout_girl= (RelativeLayout) view.findViewById(R.id.layout_girls_more_info);
            circleImage = (SimpleDraweeView) view.findViewById(R.id.girls_profile);
            final Uri imageUri = Uri.parse("http://www.montana.edu/nativeamerican/images/Images/avatar_woman.jpg");
            circleImage.setImageURI(imageUri);

            relativeLayout_girl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent iNext = new Intent(context, GirlsDetailsActivity.class);
                    context.startActivity(iNext);

                }
            });
/*            btn_more_info = (Button) view.findViewById(R.id.btn_more_info);
            btn_more_info.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent iNext = new Intent(context, GirlsDetailsActivity.class);
                    context.startActivity(iNext);

                }
            });*/
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_girls_candidates, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(GirlsCandidatesAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
