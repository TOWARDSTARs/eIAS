package com.project.eIASbackend.dto;

import com.project.eIASbackend.entity.Material;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.multipart.MultipartFile;

@EqualsAndHashCode(callSuper = true)
@Data
public class MaterialFileDto extends Material {
    MultipartFile file;             //用于上传的文件
}
