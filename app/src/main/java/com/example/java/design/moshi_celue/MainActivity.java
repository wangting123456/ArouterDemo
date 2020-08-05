package com.example.java.design.moshi_celue;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.java.design.moshi_celue.demo.AirStrategy;
import com.example.java.design.moshi_celue.demo.Traveler;

/**
 * 策略模式
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.什么是策略模式
          //定义了算法家族，分别包装起来，让他们之间可以互相替换，此模式让算法的变化，不会影响使用变法的客户
        //2.什么时候去使用策略模式
          //策略模式就是用来封装算法的，但是在实践中，我们发现可以用它来封装几乎任何类型的规则，只要
          //在分析过程中听到需要在不同时间应用不同的业务规则，就可以考虑使用策略模式处理这种变化的可能性。
        //3.适用的场景
          //如果在一个系统里面有很多类，他们之间的区别仅仅是行为，那么使用策略模式可以动态的让一个对象选择一个行为
          //一个系统需要动态的在几种算法中选择一种
          //如果一个对象有很多的形式，不适用恰当的模式，这些行为就只能使用多重的条件语句来执行
        //4.策略模式优点
          //由于实例化不同的策略，所以最终在调用context.ContextInterface();时，所获得的的结果就不尽相同
          //策略模式遵循开闭原则，实现代码的解耦和，扩展新的方式时比较方便，只需要继承策略接口据好了
          //我们之前在选择出行方式的时候，使用if-else分支，这样情况耦合性太高了
        //5.缺点
          //客户端必须知道所有的策略类，手动进行选择
          //策略模式会出现很多的策略类
          //context在使用这些策略类的时候，这些策略类由于继承了策略接口，所以有些数据可能用不到，但是依然初始化了。
          StrategyModel model = new StrategyModel(new StrategyA());
          StrategyModel model1 = new StrategyModel(new StrategyB());

          //demo
          Traveler traveler = new Traveler();
          traveler.setTravelStrage(new AirStrategy());
          traveler.travel();
          //demo2
          //老师讲数学题时，有好几种解法，只需要一种就可以了。
    }
}
