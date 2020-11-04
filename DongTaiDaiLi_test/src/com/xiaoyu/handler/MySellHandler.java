package com.xiaoyu.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


//必须实现InvocationHandler 来完成代理类要完成的功能（1.调用目标方法 2.执行功能增强）
public class MySellHandler implements InvocationHandler {

    private Object target;
    //动态代理，目标对象是活动的，不是固定的，需要传入进来，传入谁就给谁创建代理
    public MySellHandler(Object target) {
        this.target = target;//target就是目标对象，给目标对象赋值
        //当前对象就是target  当前对象就是InvocationHandler handler = new MySellHandler(factory)
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object res = null;
        res = method.invoke(target,args);//执行目标方法  返回值是Object类型的

        if(res != null){
            Float price = (Float)res;
            price = price + 25;
            res = price;
        }
        return  res;
    }
}
