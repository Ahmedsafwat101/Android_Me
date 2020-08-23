package com.example.android.android_me.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {
    //TAG
    private static final String TAG = "BodyPartFragment";
    private static final String INDEX_ID = "indexID";
    private static final String lIST_IMAGE = "listImage";



    //Constructor
    private  int mIndex;
    private List<Integer>mImageIds;

    public BodyPartFragment() {

    }



    //OnCreateView
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(savedInstanceState!=null){
            mImageIds=savedInstanceState.getIntegerArrayList(lIST_IMAGE);
            mIndex=savedInstanceState.getInt(INDEX_ID);
        }
        //Inflate the view into the container
        View rootView= inflater.inflate(R.layout.fragment_body_part,container,false);
        //Get reference to the fragment view
        final ImageView imageView= (ImageView)rootView.findViewById(R.id.fragment_body_id);
        //Set imageView
        if(mImageIds!=null){
        imageView.setImageResource(mImageIds.get(mIndex));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mIndex<mImageIds.size()-1)
                    mIndex++;
                else
                    mIndex=0;

                imageView.setImageResource(mImageIds.get(mIndex));

            }
        });
        }else {
            Log.i(TAG, "This fragment has a null list of image id's");
        }
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putIntegerArrayList(lIST_IMAGE,new ArrayList<Integer>(mImageIds));
        outState.putInt(INDEX_ID,mIndex);
    }

    public void setmIndex(int mIndex) {
        this.mIndex = mIndex;
    }

    public void setmImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }
}
