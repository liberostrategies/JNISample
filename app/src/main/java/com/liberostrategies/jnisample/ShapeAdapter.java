/*
 * Copyright (c) 2017. Libero Strategies, LLC - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and Confidential
 */

package com.liberostrategies.jnisample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Adapter for RecyclerView.
 */

public class ShapeAdapter extends RecyclerView.Adapter<ShapeAdapter.ShapeAdapterViewHolder> {
    private static final String LOG_TAG = ShapeAdapter.class.getSimpleName();

    private static Context mContext;
    private ArrayList<Triangle> mShapes = new ArrayList<>();

    public ShapeAdapter(Context context) {
        mContext = context;
        mShapes.add(new Triangle("Triangle 1"));
        mShapes.add(new Triangle("Triangle 2"));
    }

    @Override
    public ShapeAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            int layoutId = R.layout.card_shape;
            View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
            view.setFocusable(true);
            return new ShapeAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShapeAdapterViewHolder holder, int position) {
        Triangle itemTriangle = mShapes.get(position);
        holder.bindShape(itemTriangle);
    }

    @Override
    public int getItemCount() {
        return mShapes.size();
    }

    public static class ShapeAdapterViewHolder extends RecyclerView.ViewHolder {
        private TextView mDescription;
        private MyGLSurfaceView mSurface;

        public ShapeAdapterViewHolder(View v) {
            super(v);
            mDescription = (TextView)v.findViewById(R.id.card_shape_name);
            mSurface = (MyGLSurfaceView)v.findViewById(R.id.card_shape_surface);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "Clicked on  " + mDescription.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void bindShape(Triangle triangle) {
            mDescription.setText(triangle.getmDescription());
            triangle.drawTriangleFromJNI();
        }

    }

}
