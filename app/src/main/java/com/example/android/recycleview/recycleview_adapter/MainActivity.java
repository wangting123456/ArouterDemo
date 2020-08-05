package com.example.android.recycleview.recycleview_adapter;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.RecycleView.Adapter 扮演的角色
          //a.根据不同的viewType创建不同的ItemLayout
          //b.访问数据集合，并将数据绑定到正确的View上

        //2.重写的方法
          //a.public VH onCreateViewHolder(ViewGroup parent,int viewType)
              //创建Item视图，并返回对应的ViewHolder
          //b.public void onBindViewHolder(VH viewholder,int postion)
              //绑定数据到正确的Item视图上
          //c.public int getItemCount()
              //返回该Adapter所持有的Item数量
          //d.public int getItemViewType(int postion)
             //用来获取当前项Item(postion)是哪种类型的布局

        //3.notifyDataSetChanged()刷新数据
            //当数据集合发生改变时候，会调用notifyDataSetChanged()来刷新列表，这样做会触发列表的重置，
            //所以不会有任何的动画出现，因此需要调用一些以notifyItem**的方法
            //a.notifyItemInsert(int postion);向指定位置插入Item
            //b.notifyItemRemove(int postion);移除指定位置的数据
            //c.notifyItemChange(int postion);更换指定位置的数据

        //4.数据变化通知之观察者模式
           //public final void notifyDataSetChanged() {
            //    mObservable.notifyChanged();
           //}
    }
}
