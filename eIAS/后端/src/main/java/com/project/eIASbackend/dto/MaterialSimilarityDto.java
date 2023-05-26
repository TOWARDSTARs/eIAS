package com.project.eIASbackend.dto;

import com.project.eIASbackend.entity.Material;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MaterialSimilarityDto extends Material {
    double similarity;
}
