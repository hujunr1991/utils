package com.example.springboorutil.office.excel.pictureTobase64;

import org.springframework.util.Base64Utils;

import java.io.IOException;


public class Test {
    public static void main(String[] args) throws IOException {
//        String imageStr = Base64Utils.GetImageStr("D://下载/企鹅.jpg");
//        System.out.println(imageStr);
//        Base64Utils.GenerateImage(imageStr, "D://photos/企鹅.jpg");

        String images = "1111113434432cf";
        String[] split = images.split(",");
        if (split.length>1){
            String str = split[1];
            System.out.println(str);
        }
    }

}
