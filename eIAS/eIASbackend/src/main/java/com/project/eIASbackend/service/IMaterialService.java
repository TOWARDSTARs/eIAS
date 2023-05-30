package com.project.eIASbackend.service;

import com.github.pagehelper.PageInfo;
import com.project.eIASbackend.dto.EsQueryDto;
import com.project.eIASbackend.dto.FuzzyQueryDto;
import com.project.eIASbackend.dto.MaterialDto;
import com.project.eIASbackend.entity.Material;
import com.baomidou.mybatisplus.extension.service.IService;
import com.project.eIASbackend.entity.Project;
import com.project.eIASbackend.exception.SameMaterialNameException;
import io.swagger.annotations.ApiParam;
import org.springframework.web.multipart.MultipartFile;

import java.awt.geom.QuadCurve2D;
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
public interface IMaterialService extends IService<Material> {
    Material addMaterial(String name, Integer projectId, MultipartFile file, String upperPath) throws SameMaterialNameException;

    FuzzyQueryDto fuzzyQuery(EsQueryDto esQueryDto) throws Exception;

    //删除服务器或者本地上的资料
    void deleteMaterial(Integer id);

    PageInfo<MaterialDto> getPagedMaterial(Integer pageNum, int pageSize, int navSize, String materialName, Integer projectId, String projectName);

    Map<Integer, Material> getMaterialMap();

    void delete_vec_txt_file(Material material, String basePathT);

    void deleteElasticsearchDoc(Material material) throws IOException;

    void deleteById(Integer id);


    double similarity(Integer materialIdA, Integer materialIdB) throws IOException;

}
