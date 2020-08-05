package com.example.android.recycleview.recycleview_itemtouchhelper;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.recycleview.recycleview_pulltorefresh.MyWtAdapter;
import com.example.arouterdemo.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TouchMoveActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PersonAdapter personAdapter;
    private List<PersonData> mData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_recycle_itemtouch);
        initRecycleView();
        initCallBack();
    }

    private void initRecycleView(){
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        final RecycleViewItemLine line = new RecycleViewItemLine(this, LinearLayout.HORIZONTAL,
                1,
                this.getResources().getColor(R.color.colorAccent));
        recyclerView.addItemDecoration(line);
        mData = getPersonList(0);
        personAdapter = new PersonAdapter(this,mData);
        recyclerView.setAdapter(personAdapter);
        personAdapter.notifyDataSetChanged();
    }
    private void initCallBack(){
       ItemTouchHelpCallback callback = new ItemTouchHelpCallback(
               new ItemTouchHelpCallback.OnItemTouchCallbackListener(){

                   @Override
                   public void onSwiped(int adapterPosition) {
                       if(mData != null){
                           mData.remove(adapterPosition);
                           personAdapter.notifyItemRemoved(adapterPosition);
                       }
                   }

                   @Override
                   public boolean onMove(int srcPosition, int targetPosition) {
                       if(mData != null){
                           Collections.swap(mData,srcPosition,targetPosition);
                           personAdapter.notifyItemMoved(srcPosition,targetPosition);
                       }
                       return false;
                   }
               });
    }

    public static List<PersonData> getPersonList(int size){
        if (size==0){
            size = 16;
        }
        ArrayList<PersonData> arr = new ArrayList<>();
        for (int i=0 ; i< size ; i++){
            PersonData person = new PersonData();
            person.setName("小杨逗比"+i);
            person.setSign("杨充"+i);
            arr.add(person);
        }
        return arr;
    }
}
