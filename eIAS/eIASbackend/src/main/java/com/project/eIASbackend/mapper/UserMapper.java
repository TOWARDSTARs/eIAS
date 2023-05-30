package com.project.eIASbackend.mapper;

import com.project.eIASbackend.entity.Material;
import com.project.eIASbackend.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zxin
 * @since 2023-05-11
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @MapKey("id")
    @Select("select id,user_name from user")
    Map<Integer, User> getUserMap();
}
