/*
 * Copyright (c) 2017. Libero Strategies, LLC - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and Confidential
 */

package com.liberostrategies.jnisample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private ShapeAdapter mShapeAdapter;
    private RecyclerView mRecyclerViewShapes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.main_instructions);
        tv.setText(stringFromJNI());

        mShapeAdapter = new ShapeAdapter(this);
        mRecyclerViewShapes = (RecyclerView)findViewById(R.id.recycler_shapes);
        mRecyclerViewShapes.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewShapes.setItemAnimator(new DefaultItemAnimator());
        mRecyclerViewShapes.setAdapter(mShapeAdapter);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

}
