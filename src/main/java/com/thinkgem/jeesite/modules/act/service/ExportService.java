package com.thinkgem.jeesite.modules.act.service;


import com.thinkgem.jeesite.modules.act.entity.BaseData;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExportService {

    @Autowired
    BaseDataService baseDataService;

    String[] excelHeader = {"校区名称", "网络地址段（多）", "掩码", "ip地址（多）", "使用设备", "使用部门", "存放位置", "用户名", "密码（不显示）", "备注"};

    // 单元格列宽
    int[] excelHeaderWidth = { 140, 140, 140, 140, 140, 140, 120, 120, 140,140 };

    public HSSFWorkbook export() {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("ip数据统计表");
        HSSFRow row = sheet.createRow((int) 0);
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        for (int i = 0; i < excelHeader.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(excelHeader[i]);
            cell.setCellStyle(style);
            sheet.autoSizeColumn(i);
        }
        // 设置列宽度（像素）
        for (int i = 0; i < excelHeaderWidth.length; i++) {
            sheet.setColumnWidth(i, 32 * excelHeaderWidth[i]);
        }

        List<BaseData> list = baseDataService.getAll();
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow(i + 1);
            BaseData baseData = list.get(i);
            row.createCell(0).setCellValue(baseData.getCampusName());
            row.createCell(1).setCellValue(baseData.getNetworkAddress());
            row.createCell(2).setCellValue(baseData.getMask());
            row.createCell(3).setCellValue(baseData.getIp());
            row.createCell(4).setCellValue(baseData.getUsingEquipment());
            row.createCell(5).setCellValue(baseData.getUsingDepartment());
            row.createCell(6).setCellValue(baseData.getStoragePosition());
            row.createCell(7).setCellValue(baseData.getUsername());
            row.createCell(8).setCellValue(baseData.getPassword());
            row.createCell(9).setCellValue(baseData.getRemarks());
        }
        return wb;
    }

    public HSSFWorkbook exportTemplate() {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("ip数据统计表");
        HSSFRow row = sheet.createRow((int) 0);
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        for (int i = 0; i < excelHeader.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(excelHeader[i]);
            cell.setCellStyle(style);
            sheet.autoSizeColumn(i);
        }
        // 设置列宽度（像素）
        for (int i = 0; i < excelHeaderWidth.length; i++) {
            sheet.setColumnWidth(i, 32 * excelHeaderWidth[i]);
        }

        List<BaseData> list = new ArrayList<BaseData>();
        list.add(new BaseData("总部校区","10.152.25.0","255.255.255.0","10.152.25.1","路由器","网络运营部","水清机房","admin","XXXXX","上一行标题不变，删除本示例行开始编辑"));
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow(i + 1);
            BaseData baseData = list.get(i);
            row.createCell(0).setCellValue(baseData.getCampusName());
            row.createCell(1).setCellValue(baseData.getNetworkAddress());
            row.createCell(2).setCellValue(baseData.getMask());
            row.createCell(3).setCellValue(baseData.getIp());
            row.createCell(4).setCellValue(baseData.getUsingEquipment());
            row.createCell(5).setCellValue(baseData.getUsingDepartment());
            row.createCell(6).setCellValue(baseData.getStoragePosition());
            row.createCell(7).setCellValue(baseData.getUsername());
            row.createCell(8).setCellValue(baseData.getPassword());
            row.createCell(9).setCellValue(baseData.getRemarks());
        }
        return wb;
    }
}

