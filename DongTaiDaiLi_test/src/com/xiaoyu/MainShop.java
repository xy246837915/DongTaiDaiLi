package com.xiaoyu;

import com.xiaoyu.handler.MySellHandler;
import com.xiaoyu.service.UsbSell;
import com.xiaoyu.service.factory.UsbKingFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MainShop {
    public static void main(String[] args) {
        //创建代理对象，使用proxy
        //1.创建目标对象
        UsbSell factory  = new UsbKingFactory();
        //2.创建InvocationHandler对象
        InvocationHandler handler = new MySellHandler(factory);
        //3.创建代理对象 返回值转成接口类型                     //获取对象的类加载器
        UsbSell proxy = (UsbSell) Proxy.newProxyInstance(factory.getClass().getClassLoader(),
                               //获取接口
                               factory.getClass().getInterfaces(),
                               handler);//InvocationHandler对象

        //通过代理执行方法
        float price = proxy.sell(5);//这里实执行的是 InvocationHandler的invoke()方法
        System.out.println("通过代理对象，调用方法  价格为=" + price);
        System.out.println(proxy.getClass().getName());
    }
}
