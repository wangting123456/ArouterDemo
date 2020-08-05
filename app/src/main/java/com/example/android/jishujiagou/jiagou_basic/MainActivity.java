package com.example.android.jishujiagou.jiagou_basic;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Android技术架构
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //一.Android技术架构有哪几种
          //a.MVC
             //MVC全名是Model View Controller，如图，是模型(model)－视图(view)－控制器(controller)的缩写，
             // 一种软件设计典范，用一种业务逻辑、数据、界面显示分离的方法组织代码，在改进和个性化定制界面及
             // 用户交互的同时，不需要重新编写业务逻辑。
          //b.MVP
             //MVP从更早的MVC框架演变过来，与MVC有一定的相似性：Controller/Presenter负责逻辑的处理，
             //Model提供数据，View负责显示。
          //c.MVVM

        //二.MVC架构简单介绍
          //1.MVC介绍
           //a.Model View Controller，是软件架构中最常见的一种框架，通过控制Controller去操作Model层的数据
             //并且返回给View显示
           //b.工作原理:当用户出发事件的时候，view层会发送指令到controller层，接着controller去通知model
            // 层更新数据，model层更新完数据以后直接显示在view层上，这就是MVC的工作原理。
         //2.Android实际应用场景
           //a.视图层(View):   layout.xml里面的xml文件就对应于MVC的view层，里面都是一些view的布局代码，
           //b.控制层(Controller):至于controller层嘛，当然就是各种activity咯。
           //c.模型层(Model): 而各种Java bean，还有一些类似repository类就对应于model层，
           //比如你的界面有一个按钮，按下这个按钮去网络上下载一个文件，这个按钮是view层的，是使用xml来写的，
           // 而那些和网络连接相关的代码写在其他类里，比如你可以写一个专门的networkHelper类，这个就是model层，
           // 那怎么连接这两层呢？是通过button.setOnClickListener()这个函数，这个函数就写在了activity中，对应于controller层
         //3.MVC缺陷:
           //a.问题就在于xml作为view层，控制能力实在太弱了，你想去动态的改变一个页面的背景，或者动态的
             //隐藏/显示一个按钮，这些都没办法在xml中做，只能把代码写在activity中，造成了activity既是controller
             //层，又是view层的这样一个窘境。
          //b.Activity并不是一个标准的MVC模式中的Controller，它的首要职责是加载应用的布局和初始化用户
             //界面，并接受并处理来自用户的操作请求，进而作出响应。随着界面及其逻辑的复杂度不断提升，
             //Activity类的职责不断增加，以致变得庞大臃肿。

        //三.MVP架构简单介绍
          //1.MVP简单介绍
            //MVP作为MVC的演化，解决了MVC不少的缺点，对于Android来说，MVP的model层相对于MVC是一样的，
            //而activity和fragment不再是controller层，而是纯粹的view层，所有关于用户事件的转发全部交由presenter层处理。
          //2.MVP工作原理
            //a.MVP框架由3部分组成：View负责显示，Presenter负责逻辑处理，Model提供数据
               //View:负责绘制UI元素、与用户进行交互(在Android中体现为Activity)
               //Model:负责存储、检索、操纵数据(有时也实现一个Model interface用来降低耦合)
               //Presenter:作为View与Model交互的中间纽带，处理与用户交互的负责逻辑。
          //3.MVP架构的优缺点
             //a.MVP优点：
               //1.Model与View完全分离，彻底解耦
               //2.Presenter复用，可以将一个Presenter用于多个视图，而不用改变Presenter的逻辑
               //3.可以实现View接口进行逻辑测试（Presenter的单元测试）
             //b.MVP的缺点及优化：
               //1.View层过大，Activity复杂，加入模板方法，分离出BaseActivity用于处理公共逻辑
               //2.Model层过大，做好模块划分，进行接口隔离，在内部进行分层。
               //3.还有一个问题是，MVP额外的增加了很多类和接口,这个可以根据项目实际情况进行相应地优化
        //四.MVVM架构简单介绍
           //1.MVVM工作原理
             //和MVP区别不是很大，只不过presenter换成了ViewModel层，还有一点是view层和viewmodel层是互相绑定
             //的关系，这意味着你更新ViewModel层数据的时候，View层会相应的更新UI

        //五.三者之间比较
          //a.MVP是从MVC演变过来的，基本思想有相同的地方:Controller/Presenter负责逻辑的处理，Model提供数据，
             //View负责显示,所以他们之间并没有特别大的不同，都是用来将View和Model之间松耦合
          //b.作为一种新的模式，MVP与MVC有着一个重大的区别:在MVP中View并不直接使用Model，它们之间的通
             //信是通过Presenter (MVC中的Controller)来进行的，所有的交互都发生在Presenter内部，而在MVC中是
             //允许Model和View进行交互的。还有重要的一点就是Presenter与View之间的交互是通过接口的
          //c.MVVM是通过MVP演变而来的，主要用了data binding来实现双向交互，这就使得视图和控制层之间的
             //耦合程度进一步降低，关注点分离更为彻底，同时减轻了Activity的压力。
          //d.MVVM
             //用户直接交互的是View。
             //View和ViewModel是多对一的关系。
             //View有ViewModel的引用，但是ViewModel没有任何关于View的信息。
             //支持View和ViewModel的双向数据绑定。
             //这里的ViewModel就是ViewModelProviders里面的ViewModel

        // Model     View       Controller
        // 实体模型   xml布局文件 对应于Activity业务逻辑

        //Model     View       Presenter
        //实体模型  对应Activity/Fragment/自定义View  负责数据处理以及view和model的交互，持有model和view的引用

        //Mode      View        ViewModel
        //实体模型  对应Activity/Fragment/自定义View 负责业务逻辑处理，负责view和model的交互，和view层双向绑定
    }
}
