package com.example.java.design.moshi_moban.demo2;

/**
 * 步骤1:创建一个抽象类，它的模板方法被设置为final
 */
public abstract class Game {
    abstract void init();
    abstract void startPlay();
    abstract void endPlay();

    //模板方法
    public  final void play(){
        //初始化游戏
       init();
       //开始游戏
       startPlay();
       //结束游戏
       endPlay();
    }
}
