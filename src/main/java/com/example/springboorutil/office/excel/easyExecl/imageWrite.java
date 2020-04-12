package com.example.springboorutil.office.excel.easyExecl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class imageWrite  {


    @Test
    public void imageWrite() throws Exception {
        String fileName = "imageWrite" + System.currentTimeMillis() + ".xlsx";
        // 如果使用流 记得关闭
        InputStream inputStream = null;
        try {
            List<ImageData> list = new ArrayList<ImageData>();
            ImageData imageData = new ImageData();
            list.add(imageData);
            String imagePath = "D:\\1.jpg";
            // 放入五种类型的图片 根据实际使用只要选一种即可
//            imageData.setByteArray(FileUtils.readFileToByteArray(new File(imagePath)));
//            imageData.setFile(new File(imagePath));
            imageData.setString(imagePath);
//            inputStream = FileUtils.openInputStream(new File(imagePath));
//            imageData.setInputStream(inputStream);
//            imageData.setUrl(new URL(
//                    "https://raw.githubusercontent.com/alibaba/easyexcel/master/src/test/resources/converter/img.jpg"));
            EasyExcel.write(fileName, ImageData.class).sheet().doWrite(list);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

}
