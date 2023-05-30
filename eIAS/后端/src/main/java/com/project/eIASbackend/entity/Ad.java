package com.project.eIASbackend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zxin
 * @since 2023-05-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ad")
@ApiModel(value="Ad对象", description="")
public class Ad implements Serializable {

    private static final long serialVersionUID = 1L;                    //指定序列化版本号

    @ApiModelProperty(value = "广告id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "广告名称")
    private String name;

    @ApiModelProperty(value = "广告所属项目id")
    private Integer projectId;


    @ApiModelProperty(value = "所属用户的id")
    private Integer userId;

    @ApiModelProperty(value = "广告的摘要")
    private String summary;



}
