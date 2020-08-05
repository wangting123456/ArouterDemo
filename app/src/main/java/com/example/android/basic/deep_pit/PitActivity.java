package com.example.android.basic.deep_pit;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class PitActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      /*  bundle使用场景
        Fragment之间传递数据；比如，某个Fragment中点击按钮弹出一个DialogFragment。最便捷的方式就是通过Fragment.setArguments(args)传递参数。
        public static void showFragmentDialog(String title, String content, boolean is_open, AppCompatActivity activity) {
            ServiceDialogFragment mainDialogFragment = new ServiceDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            bundle.putString("content", content);
            bundle.putBoolean("is_open",is_open);
            mainDialogFragment.setArguments(bundle);
            mainDialogFragment.show(activity.getSupportFragmentManager());
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            setLocal(Local.CENTER);
            super.onCreate(savedInstanceState);
            Bundle bundle = getArguments();
            if (bundle != null) {
                title = bundle.getString("title");
                content = bundle.getString("content");
                is_open = bundle.getBoolean("is_open");
            }
        }*/
    }
}
