//记录管理控制器：查询、删除
package com.project.eIASbackend.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.eIASbackend.common.R;
import com.project.eIASbackend.common.UserHolder;
import com.project.eIASbackend.entity.Record;
import com.project.eIASbackend.service.IRecordService;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zxin
 * @since 2023-05-18
 */
@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    public IRecordService recordService;

    @GetMapping("/getFirstFive")
    public R<List<Record>> getFirstFive(){
        Integer currentId = UserHolder.getUser().getId();
        LambdaQueryWrapper<Record> recordLambdaQueryWrapper = new LambdaQueryWrapper<>();
        recordLambdaQueryWrapper.orderByDesc(Record::getTime);
        recordLambdaQueryWrapper.last("limit 5");
        recordLambdaQueryWrapper.eq(Record::getUserId,currentId);
        List<Record> list = recordService.list(recordLambdaQueryWrapper);
        return R.success(list);
    }

    @GetMapping("/getRecords")
    public R<List<Record>> getRecords( String keyword, String startTime, String endTime){
        Integer currentId = UserHolder.getUser().getId();
        LambdaQueryWrapper<Record> recordLambdaQueryWrapper = new LambdaQueryWrapper<>();
        recordLambdaQueryWrapper.orderByDesc(Record::getTime);
        recordLambdaQueryWrapper.eq(Record::getUserId,currentId);
        if(keyword!=null&&!keyword.equals("")){
            recordLambdaQueryWrapper.like(Record::getInformation,keyword);
        }
        if(startTime!=null&&!startTime.equals("")){
            DateTime start = DateTime.parse(startTime);
            LocalDateTime localDateTime = Instant.ofEpochMilli(start.getMillis()).atZone(start.getZone().toTimeZone().toZoneId()).toLocalDateTime();
            recordLambdaQueryWrapper.ge(Record::getTime, localDateTime);
        }
        if(endTime!=null&&!endTime.equals("")){
            DateTime end = DateTime.parse(endTime);
            LocalDateTime localDateTime = Instant.ofEpochMilli(end.getMillis()).atZone(end.getZone().toTimeZone().toZoneId()).toLocalDateTime();
            recordLambdaQueryWrapper.le(Record::getTime,localDateTime);
        }
        List<Record> list = recordService.list(recordLambdaQueryWrapper);
        return R.success(list);
    }

    @GetMapping("/delete")
    public R<Boolean> delete(Integer id){
        return R.success(recordService.removeById(id));
    }
}
