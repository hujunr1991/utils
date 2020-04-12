package com.example.springboorutil.office.excel.easyPoi;

import com.alibaba.excel.util.DateUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TestClass {


    /**
     * 传入要下载的图片的url列表，将url所对应的图片下载到服务器本地
     * @param fileName 服务器存储路径
     * @param urlList 阿里云图片地址集合
     * @return 返回服务器下载图片的路径集合
     */
    private List<String> downloadPicture(String fileName,List<String> urlList) {
        File file=new File(fileName);
        // 不存在则创建文件夹
        if (!file.exists()){
            file.mkdir();
        }
        long imageNumber = System.currentTimeMillis();
        List<String> imageList=new ArrayList<>();
        URL url = null;
        for (String urlString : urlList) {
            try {
                url = new URL(urlString);
                DataInputStream dataInputStream = new DataInputStream(url.openStream());
                Random random=new Random();
                int rd=random.nextInt(9999);
                String imageName = imageNumber+""+rd + ".jpg";
                FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName+"/"+imageName));
                byte[] buffer = new byte[1024];
                int length;
                while ((length = dataInputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, length);
                }
                dataInputStream.close();
                fileOutputStream.close();
                imageList.add(fileName+"/"+imageName);
                imageNumber++;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return imageList;
    }


    /**
     * 导出带图片的Excel
     * @param fileName
     * @param list
     * @param response
     */
    private void exportBreakRuleExcel(String fileName,List<TBreakRule>list, HttpServletResponse response){

        String now=DateUtils.format(new Date(),"yyyyMMddHHmmss");
        for (TBreakRule tBreakRule:list){
            // 将三张图片url分割，进行下载
            String[] pictures=tBreakRule.getPicture().split(",");
            List<String>imageList=new ArrayList<>();
            for (int i=0;i<pictures.length;i++){
                imageList.add(pictures[i]);
            }

            // 下载图片
            List<String> filePaths=downloadPicture(fileName,imageList);
            for (int j=0;j<filePaths.size();j++){
                switch (j){
                    case 0:
                        tBreakRule.setPicture1(filePaths.get(j));
                        break;
                    case 1:
                        tBreakRule.setPicture2(filePaths.get(j));
                        break;
                    case 2:
                        tBreakRule.setPicture3(filePaths.get(j));
                        break;
                }
            }
        }
        EasyPoiUtil.exportExcel(list,"城市违章车辆管理平台","违章数据",TBreakRule.class,"违停数据"+now+".xls",response);

    }


}
