package com.myrpcdemo.rpcclient;

import com.myrpcdemo.rpcserver.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ：Nan
 * @date ：Created in 2019/6/23 14:38
 */
public class RemoteInvocationHandler implements InvocationHandler {

    private String host;
    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParams(args);
        rpcRequest.setVersion("v1.1");
        RpcNetTransport rpcNetTransport = new RpcNetTransport(host,port);
        Object result = rpcNetTransport.send(rpcRequest);
        return result;
    }
}
