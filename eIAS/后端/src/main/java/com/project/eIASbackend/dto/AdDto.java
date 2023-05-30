package com.project.eIASbackend.dto;

import com.project.eIASbackend.entity.Ad;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AdDto extends Ad {
    private String projectName;
    private String userName;

    public AdDto(Ad ad){
        this.setId(ad.getId());
        this.setName(ad.getName());
        this.setProjectId(ad.getProjectId());
        this.setUserId(ad.getUserId());
        this.setSummary(ad.getSummary());
    }
}
