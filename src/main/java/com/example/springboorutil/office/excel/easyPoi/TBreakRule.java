package com.example.springboorutil.office.excel.easyPoi;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class TBreakRule implements Serializable {
    /**
     * id
     */
    @Excel(name = "编号", orderNum = "1")
    private Integer id;

    @Excel(name = "违停编号", width = 25, orderNum = "2")
    private String breakCode;

    /**
     * 车牌号
     */
    @Excel(name = "车牌号", orderNum = "3")
    private String plateNumber;

    /**
     * 地址
     */
    @Excel(name = "地址", width = 60, orderNum = "4")
    private String address;

    /**
     * 图片
     */
    private String picture;


    @Excel(name = "车辆正面照片", type = 2, width = 50, height = 60, orderNum = "5")
    private String picture1;
    @Excel(name = "车辆左侧照片", type = 2, width = 50, height = 60, orderNum = "5")
    private String picture2;
    @Excel(name = "车辆右侧照片", type = 2, width = 50, height = 60, orderNum = "5")
    private String picture3;

    /**
     * 违章信息
     */
    @Excel(name = "违章信息", orderNum = "6")
    private String breakInfo;

    /**
     * 车牌颜色
     */
    @Excel(name = "车牌颜色", orderNum = "7")
    private String plateColor;

    /**
     * 01：大型车。02：小型车 07：2，3轮摩托车，08：轻便摩托车。13：农用运输车
     */
    @Excel(name = "车辆类型", replace = {"大型车_01", "小型车_02", "摩托车_07", "轻便摩托车_08", "农用运输车_13"}, orderNum = "8")
    private String carType;

    /**
     * 车颜色
     */
    @Excel(name = "车身颜色", suffix = "色", orderNum = "9")
    private String carColor;

    /**
     * 创建时间
     */
    @Excel(name = "创建时间", format = "yyyy-MM-dd HH:mm:ss", width = 20, orderNum = "9")
    private Date createTime;

    /**
     * 创建人
     */
    @Excel(name = "创建人", orderNum = "20")
    private String createBy;

    private Date updateTime;

    private String updateBy;

    private String delFlag;

    /**
     * 10：待审核，20：警告，30：待处理，40：待缴费，50：已处理，60：已推送，70：已作废
     */
    @Excel(name = "状态", replace = {"待审核_10", "警告_20", "待处理_30", "待缴费_40", "已处理_50", "已推送_60", "已作废_70", "已推送（旧数据）_4"}, orderNum = "11")
    private String status;


    /**
     * 0.未推送 1.已推送
     */
    @Excel(name = "推送状态", replace = {"未推送_0", "已推送_1"}, orderNum = "12")
    private String pushStatus;

    /**
     * 用户id
     */
    private Integer userId;

    @org.springframework.format.annotation.DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;

    @org.springframework.format.annotation.DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

}

