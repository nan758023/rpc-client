package com.myrpcdemo.rpcclient;

import com.myrpcdemo.rpcserver.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author ：Nan
 * @date ：Created in 2019/6/23 14:59
 */
public class RpcNetTransport {
    private String Host;
    private int port;

    public RpcNetTransport(String host, int port) {
        Host = host;
        this.port = port;
    }
    public Object send(RpcRequest rpcRequest){
        Socket socket = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        Object result = null;
        try {
            socket = new Socket(Host, port);
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(rpcRequest);
            oos.flush();
            ois = new ObjectInputStream(socket.getInputStream());
            result = ois.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return  result;
    }
}
