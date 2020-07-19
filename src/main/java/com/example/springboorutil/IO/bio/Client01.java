package com.example.springboorutil.IO.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Client01 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8000);

        OutputStream outputStream = socket.getOutputStream();

        //控制台输入以IO的形式发送到服务器
        System.out.println("TCP连接成功 \n请输入：");
        String str = new Scanner(System.in).nextLine();
        byte[] car = str.getBytes();
        outputStream.write(car);
        System.out.println("TCP协议的Socket发送成功");
        //刷新缓冲区
        outputStream.flush();
        //关闭连接
        socket.close();



    }
}
