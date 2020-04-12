package com.example.springboorutil.nio;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestNio {


    @Test
    public void test01() throws IOException {
        //1、先创建输出流
        FileOutputStream fos = new FileOutputStream("bos.txt");
        //2、从流中得到一个通道
        FileChannel channel = fos.getChannel();
        //3、提供一个缓冲区
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        //4、往缓冲区存入数据
        String str = "hello nio";
        allocate.put(str.getBytes());
        //5、翻转缓冲区
        allocate.flip();
        //6、把缓冲后期写入通道
        channel.write(allocate);
        //7、关闭
        channel.close();

    }

    public static void main(String[] args) {

    }
}
