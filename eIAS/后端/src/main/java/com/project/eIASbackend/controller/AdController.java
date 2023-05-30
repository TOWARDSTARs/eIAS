//广告管理控制器：生成、保存、导出和查询
package com.project.eIASbackend.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.eIASbackend.common.R;
import com.project.eIASbackend.common.UserHolder;
import com.project.eIASbackend.dto.AdDto;
import com.project.eIASbackend.entity.Material;
import com.project.eIASbackend.entity.Project;
import com.project.eIASbackend.entity.Record;
import com.project.eIASbackend.entity.Ad;
import com.project.eIASbackend.entity.User;
import com.project.eIASbackend.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zxin
 * @since 2023-05-14
 */
@RestController
@RequestMapping("/ad")
@CrossOrigin
@Api(tags = "广告管理")
public class AdController {
    @Autowired
    IMaterialService materialService;
    @Autowired
    IProjectService projectService;
    @Autowired
    FileService fileService;
    @Autowired
    IAdService adService;
    @Autowired
    IUserService userService;
    @Autowired
    IRecordService recordService;

    //广告生成
    @GetMapping("/generate")
    @ApiOperation("生成广告")
    public R<String> generateSummary(@RequestParam("materialId") Integer materialId,Integer length){
        String result = adService.generateSummary(materialId,length);
        result=result.substring(2,result.length()-2).replace(" ","");
        return R.success(result);
    }

    //广告保存
    @PostMapping("/save")
    @ApiOperation("保存广告")
    public R<Ad> saveAd(@RequestBody Ad ad){
        Integer currentId = UserHolder.getUser().getId();
        ad.setUserId(currentId);
        adService.save(ad);
        Record record = new Record();
        record.setUserId(currentId);
        record.setTime(LocalDateTime.now());
        record.setInformation("删除"+ ad.getName()+"项目");
        recordService.save(record);
        return R.success(ad);
    }

    //数据库中Ad导出excel表格中
    @GetMapping("/download")
    @ApiOperation("导出excel广告")
    public void downloadExcel(Integer projectId,HttpServletResponse response) throws IOException {
        LambdaQueryWrapper<Ad> adLambdaQueryWrapper = new LambdaQueryWrapper<>();
        adLambdaQueryWrapper.eq(Ad::getProjectId,projectId);
        //从数据库中获取表数据
        List<Ad> list = adService.list(adLambdaQueryWrapper);
        //生成Excel表格
        XSSFWorkbook wb = adService.downloadExcel(list);
        OutputStream output = response.getOutputStream();
        // 文件名中文形式
        String fileName = "广告-" + new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date()) + ".xlsx";
        //fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        response.setContentType("application/octet-stream;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fileName,"UTF-8").replaceAll("\\+", "%20"));
        wb.write(output);
        output.close();
    }

    //数据库中ad导出Docx文档中
    @GetMapping("/downloadDocx")
    @ApiOperation("导出docx广告")
    public void downloadDocx(Integer projectId,HttpServletResponse response) throws IOException {
        XWPFDocument docx = adService.downloadDocx(projectId);
        OutputStream output = response.getOutputStream();
        // 文件名中文形式
        String fileName = "广告-" + new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date()) + ".docx";
        //fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        response.setContentType("application/octet-stream;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fileName,"UTF-8").replaceAll("\\+", "%20"));
        docx.write(output);
        output.close();
    }

    @GetMapping("/getPaged")
    @ApiOperation("获取广告分页数据")
    public R<PageInfo<Ad>> getPaged(@ApiParam("第几页")Integer pageNum, @ApiParam("一页多少条数据")int pageSize, @ApiParam("导航栏共展示几页")int navSize, @ApiParam("方案名称") String adName, @ApiParam("资料名称")String materialName, @ApiParam("资料id") Integer materialId, @ApiParam("资料对应的项目id") Integer projectId, @ApiParam("项目名称")String projectName){
        PageHelper.startPage(pageNum,pageSize);
        Integer currentId = UserHolder.getUser().getId();
        LambdaQueryWrapper<Ad> adLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(adName!=null&&!adName.equals("")){
            adLambdaQueryWrapper.or().like(Ad::getName,adName);
        }
        if(projectId!=null){
            adLambdaQueryWrapper.and(i->i.eq(Ad::getProjectId,projectId));
        }
        if(projectName!=null&& !projectName.equals("")){
            LambdaQueryWrapper<Project> projectLambdaQueryWrapper = new LambdaQueryWrapper<>();
            projectLambdaQueryWrapper.like(Project::getName,projectName);
            for (Project project : projectService.list(projectLambdaQueryWrapper)) {
                adLambdaQueryWrapper.or().eq(Ad::getProjectId,project.getId());
            }
        }
        adLambdaQueryWrapper.and(i->i.eq(Ad::getUserId,currentId));
        List<Ad> list = adService.list(adLambdaQueryWrapper);
        Map<Integer, Project> projectMap = projectService.getProjectMap();
        Map<Integer, Material> materialMap = materialService.getMaterialMap();
        Map<Integer, User> userMap = userService.getUserMap();
        ArrayList<AdDto> adDtos = new ArrayList<>();
        for(Ad ad :list){
            AdDto adDto = new AdDto(ad);
            adDto.setProjectName(projectMap.get(ad.getProjectId()).getName());
            adDto.setUserName(userMap.get(ad.getUserId()).getUserName());
            adDtos.add(adDto);
        }
        return R.success(new PageInfo<>(adDtos,navSize));
    }

    @GetMapping("/delete")
    @ApiOperation("删除广告")
    public R<String> deleteAd(@ApiParam("广告id") Integer id){
        Ad ad = adService.getById(id);
        adService.removeById(id);
        Integer currentId = UserHolder.getUser().getId();
        Record record = new Record();
        record.setUserId(currentId);
        record.setTime(LocalDateTime.now());
        record.setInformation("删除"+ ad.getName()+"广告");
        recordService.save(record);
        return R.success("删除成功");
    }

    @PostMapping("/update")
    @ApiOperation("更新广告")
    public R<String> updateAd(@RequestBody Ad ad){
        adService.updateById(ad);
        Integer currentId = UserHolder.getUser().getId();
        Record record = new Record();
        record.setUserId(currentId);
        record.setTime(LocalDateTime.now());
        record.setInformation("更新"+ ad.getName()+"广告");
        recordService.save(record);
        return R.success("更新成功");
    }
}
