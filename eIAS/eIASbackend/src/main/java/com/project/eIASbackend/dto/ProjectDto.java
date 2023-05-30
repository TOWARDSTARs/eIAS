package com.project.eIASbackend.dto;

import com.project.eIASbackend.entity.Project;
import lombok.Data;
import lombok.EqualsAndHashCode;

/************************
 * eIAsbackend
 * com.project.eIASbackend.dto
 * MHC
 * author : zxin
 * date:  2023/5/20 10:15
 * description : 
 ************************/
@EqualsAndHashCode(callSuper = true)
@Data
public class ProjectDto extends Project {
    double similarity;
    Integer id;
    String name;
    String category;
    String remark;
    public Integer getId(){
        return super.getId();
    }
    public String getName(){
        return super.getName();
    }
    public String getCategory(){
        return super.getCategory();
    }
    public String getRemark(){
        return super.getRemark();
    }
    public Project setId(Integer id){
        super.setId(id);
        return null;
    }
    public Project setName(String name){
        super.setName(name);
        return null;
    }
    public Project setCategory(String category){
        super.setCategory(category);
        return null;
    }
    public Project setRemark(String remark){
        super.setRemark(remark);
        return null;
    }
    public ProjectDto(){}

}
