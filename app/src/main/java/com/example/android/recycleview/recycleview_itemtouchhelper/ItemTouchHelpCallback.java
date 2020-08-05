package com.example.android.recycleview.recycleview_itemtouchhelper;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class ItemTouchHelpCallback extends ItemTouchHelper.Callback {
     private OnItemTouchCallbackListener onItemTouchCallbackListener;
    /**
     * 当用户拖拽或者滑动Item时，需要我们告诉系统其方向
     * @param recyclerView
     * @param viewHolder
     * @return
     */
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        return 0;
    }

    /**
     * 当Item被拖拽排序移动到另一个Item的位置的时候被调用
     * @param recyclerView
     * @param viewHolder
     * @param target
     * @return
     */
    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        if(onItemTouchCallbackListener != null){
           int src = viewHolder.getAdapterPosition();
           int des = target.getAdapterPosition();
            onItemTouchCallbackListener.onMove(src,des);
        }
        return false;
    }

    /**
     * 在onSwiped方法[当Item被滑动删除到不见]中处理被删除后的逻辑
     * @param viewHolder
     * @param direction
     */
    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        if(onItemTouchCallbackListener != null){
            onItemTouchCallbackListener.onSwiped(viewHolder.getAdapterPosition());
        }
    }
    public ItemTouchHelpCallback(OnItemTouchCallbackListener onItemTouchCallbackListener) {
        this.onItemTouchCallbackListener = onItemTouchCallbackListener;
    }
    public interface OnItemTouchCallbackListener{
        /**
         * 当某个Item被滑动删除的时候
         * @param adapterPosition item的position
         */
        void onSwiped(int adapterPosition);

        /**
         * 当两个Item位置被互调的时候回调
         * @param srcPosition 拖拽的item的position
         * @param targetPosition 目的地的Item的position
         * @return
         */
        boolean onMove(int srcPosition, int targetPosition);
    }
}
