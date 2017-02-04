package com.example.zy_mac.recyclerviewexample.adapter;

import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//import com.example.zy_mac.recyclerviewexample.R;

/**
 * Created by zy-mac on 2017/2/4.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private String[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView1;
        public TextView mTextView2;
        public ViewHolder(View v) {
            super(v);
            mTextView1 = (TextView)v.findViewById(android.R.id.text1);
            mTextView2 = (TextView)v.findViewById(android.R.id.text2);
        }
    }

    public RecyclerViewAdapter(String[] mDataset) {
        this.mDataset = mDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(parent.getContext(), android.R.layout.simple_list_item_2, null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView1.setText(mDataset[position]);
        holder.mTextView2.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
