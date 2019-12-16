package org.lsf.view;

import javax.swing.*;

public abstract class BaseFrame extends JFrame {
    /*
    * 模板模式
    * 设计一个规则
    * */

    public BaseFrame(String title){
        super(title);
    }

    public BaseFrame(){

    }


    /*设置组件的 字体 颜色 背景 布局等等*/
    protected abstract void setFontAndSoOn();


    /*将属性添加到窗体里*/
    protected abstract void addElement();

    /*添加事件监听*/
    protected abstract void addListener();

    /*设置窗体自身*/
    protected abstract void setFrameSelf();
}
