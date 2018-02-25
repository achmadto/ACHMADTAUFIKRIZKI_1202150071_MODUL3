package com.example.sei.achmadtaufikrizki_1202150071_modul3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Mineral> mMineraData;
    private MineralAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        int gridColumn = getResources().getInteger(R.integer.grid_column_count);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumn));

        mMineraData = new ArrayList<>();

        mAdapter = new MineralAdapter(this, mMineraData);
        mRecyclerView.setAdapter(mAdapter);

        initialiseData();

    }

    private void initialiseData() {
        String[] mineralList = getResources().getStringArray(R.array.merk_src);
        String[] mineralInfo = getResources().getStringArray(R.array.info_src);
        TypedArray mineralImageResource = getResources().obtainTypedArray(R.array.gambar_src);
        mMineraData.clear();

        for (int i = 0; i < mineralList.length; i++) {
            mMineraData.add(new Mineral(mineralList[i], mineralInfo[i], mineralImageResource.getResourceId(i, 0)));
        }

        mineralImageResource.recycle();

        mAdapter.notifyDataSetChanged();
    }
}

