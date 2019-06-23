package com.myrpcdemo.rpcclient;

import java.lang.reflect.Proxy;

/**
 * @author ：Nan
 * @date ：Created in 2019/6/23 14:33
 */
public class RpcProxyClient  {

    public <T> T clientProxy(final Class<T> interfaces,final String Host,final int port){
        return (T) Proxy.newProxyInstance(interfaces.getClassLoader(),new Class[]{interfaces},new RemoteInvocationHandler(Host,port));
    }
}
