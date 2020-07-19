package com.example.springboorutil.IO.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        //使用Socket进行网络通信
        Socket socket = null;

        InputStream in =null;

        OutputStream out = null;

        try {
            serverSocket = new ServerSocket(8000);
            System.out.println("服务端启动成功，监听端口为8000，等待客户端连接...");

            while (true) {
                serverSocket.accept();
                System.out.println("客户连接成功，客户信息为：" + socket.getRemoteSocketAddress());
                in = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = in.read(buffer)) >0) {
                    System.out.println(new String(buffer, 0, len));
                }
                //向客户端写数据
                out = socket.getOutputStream();
                out.write("hello!".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
