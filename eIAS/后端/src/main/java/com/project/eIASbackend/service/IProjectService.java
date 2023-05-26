package com.project.eIASbackend.service;

import com.project.eIASbackend.dto.ProjectDto;
import com.project.eIASbackend.dto.SimilarityDto;
import com.project.eIASbackend.entity.Project;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zxin
 * @since 2023-05-14
 */
public interface IProjectService extends IService<Project> {
    Map<Integer,Project> getProjectMap();

    //计算两个项目之间的相似度
    public double similarity(Integer projectIdA, Integer projectIdB) throws IOException;

    //选型分析，根据项目id获取与该项目相似度最高的五个项目信息以及相似度并返回
    public List<ProjectDto> projectAnalyze(Integer projectId) throws IOException;

    SimilarityDto similarityAnalyze(Integer project1Id, Integer project2Id) throws IOException;
}


