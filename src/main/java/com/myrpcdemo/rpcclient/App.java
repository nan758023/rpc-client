package com.myrpcdemo.rpcclient;

import com.myrpcdemo.rpcserver.IHelloService;
import com.myrpcdemo.rpcserver.IUserService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        RpcProxyClient rpcProxyClient = new RpcProxyClient();
        /*IHelloService helloService = rpcProxyClient.clientProxy(IHelloService.class,"localhost",8001);
        System.out.println(helloService.sayHello("Nan"));*/
        IUserService iUserService = rpcProxyClient.clientProxy(IUserService.class,"localhost",8001);
        System.out.println(iUserService.getUser("1"));
    }
}
