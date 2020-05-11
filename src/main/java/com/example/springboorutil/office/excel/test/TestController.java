package com.example.springboorutil.office.excel.test;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @RequestMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response) {
        String fileName = "个人信息.xlsx";
        List list = new ArrayList<>();
        Person p1 = new Person(1, "lks", 23, 1);
        Person p2 = new Person(2, "lks", 23, 0);
        Person p3 = new Person(3, "lks", 23, 1);
        Person p4 = new Person(4, "lks", 23, 0);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("个人信息", "person"), Person.class, list);
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
