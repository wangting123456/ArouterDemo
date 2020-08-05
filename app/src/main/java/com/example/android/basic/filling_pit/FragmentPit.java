package com.example.android.basic.filling_pit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.arouterdemo.R;

public class FragmentPit extends Fragment{

    private Activity mActivity = null;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        //出现getActivity空指针的原因
      /*  大多数情况下的原因：你在调用了getActivity()时，当前的Fragment已经onDetach()了宿主Activity。
        比如：你在出栈了Fragment之后，该Fragment的异步任务仍然在执行，并且在执行完成后调用了getActivity()方法，
        这样就会空指针。*/
      //解决办法
       /* 在Fragment基类里设置一个Activity mActivity的全局变量，在onAttach(Activity activity)里赋值，
       使用mActivity代替getActivity()，保证Fragment即使在onDetach后，仍持有Activity的引用（有引起内存泄露的风险，但是异步任务没停止的情况下，
        本身就可能已内存泄漏，相比Crash，这种做法“安全”些）*/

/*        public interface SendBListener {
            void send();
        }

        public class FirstFragment extends Fragment {
            SendBListener listener;

            public void setListener(SendBListener listener) {
                this.listener = listener;
            }

            @OnClick(value = R.id.tv)
            void onTvClick(View view) {
                listener.send();
            }
        }

        public class AdvanceActivity extends AppCompatActivity implements SendBListener{
            @BindView(R.id.fl_fragment)
            FrameLayout mFlFragment;

            @Override
            public void send() {
                sendBroadcast(new Intent("xxxxxx"));
            }

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                FirstFragment firstFragment=new FirstFragment();
                firstFragment.setListener(this);
            }
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }
}
