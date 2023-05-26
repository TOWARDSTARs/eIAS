package com.project.eIASbackend.mapper;

import com.project.eIASbackend.entity.Scheme;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zxin
 * @since 2023-05-14
 */
@Mapper
public interface SchemeMapper extends BaseMapper<Scheme> {

}
