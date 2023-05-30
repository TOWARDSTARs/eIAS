//
package com.project.eIASbackend.service;

import com.project.eIASbackend.entity.Ad;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zxin
 * @since 2023-05-14
 */
public interface IAdService extends IService<Ad> {
    //调用python脚本生成资料摘要(方案生成)
    public String generateSummary(Integer materialId, Integer length);

    //数据库中ad导出excel表格中(导出全部方案)
    XSSFWorkbook downloadExcel(List<Ad> list);

    //由于在工具类中无法注入bean，所以将该方法放在service中
    public void deleteCategoryFolder(String Path);

    //数据库中ad导出docx文档中(一个项目对应一个方案)
    XWPFDocument downloadDocx(Integer projectId);

    //List<Ad> getAdByMaterialId(Integer MaterialId);

    //void deleteByMaterialId(Integer MaterialId);

}

