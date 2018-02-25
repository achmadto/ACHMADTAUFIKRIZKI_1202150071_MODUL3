package com.example.sei.achmadtaufikrizki_1202150071_modul3;

/**
 * Created by Sei on 2/25/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;

public class MineralAdapter extends RecyclerView.Adapter<MineralAdapter.MineralViewHolder> {
    private GradientDrawable mGradient;
    private ArrayList<Mineral> mMineralData;
    private Context mContext;

    MineralAdapter(Context context, ArrayList<Mineral> mineralData) {
        this.mMineralData = mineralData;
        this.mContext = context;

        mGradient = new GradientDrawable();
        mGradient.setColor(Color.GRAY);

        Drawable drawable = ContextCompat.getDrawable(mContext, R.drawable.ades);
        if (drawable != null) {
            mGradient.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    @Override
    public MineralViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MineralViewHolder(mContext, LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false), mGradient);
    }

    @Override
    public void onBindViewHolder(MineralAdapter.MineralViewHolder holder, int position) {
        Mineral currentMineral = mMineralData.get(position);

        holder.bindTo(currentMineral);
        Glide.with(mContext).load(currentMineral.getImage()).into(holder.mMineralImage);
    }

    @Override
    public int getItemCount() {
        return mMineralData.size();
    }


    class MineralViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView mMineralImage;
        private TextView mTitle;
        private TextView mInfo;
        private Context mContext;
        private Mineral mCurrentMineral;
        private GradientDrawable mGradient;
        private String txtTitle;

        MineralViewHolder(Context context, View itemView, GradientDrawable gradientDrawable){
            super(itemView);

            mMineralImage = (ImageView) itemView.findViewById(R.id.mineralImage);
            mTitle = (TextView) itemView.findViewById(R.id.labelTitle);
            mInfo = (TextView) itemView.findViewById(R.id.infoTitle);

            mContext = context;
            mGradient = gradientDrawable;

            itemView.setOnClickListener(this);


            }

        void bindTo(Mineral currentMineral){
            mTitle.setText(currentMineral.getMineral());
            mInfo.setText(currentMineral.getInfo());
            mCurrentMineral = currentMineral;
            txtTitle = mTitle.getText().toString();
            Glide.with(mContext).load(currentMineral.getImage()).placeholder(mGradient).into(mMineralImage);
        }

        @Override
        public void onClick(View view) {
            Intent detail = Mineral.starter(mContext, mCurrentMineral.getMineral(), mCurrentMineral.getImage());
            detail.putExtra("title", txtTitle);
            mContext.startActivity(detail);
        }

    }
}



