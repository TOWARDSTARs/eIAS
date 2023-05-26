package com.project.eIASbackend.dto;

import com.project.eIASbackend.entity.Material;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class EsQueryDto extends Material {
    String index;
    String field;
    String word;
    Integer from;
    Integer size;
}
