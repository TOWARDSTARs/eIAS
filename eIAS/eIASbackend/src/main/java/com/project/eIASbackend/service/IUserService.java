package com.project.eIASbackend.service;

import com.project.eIASbackend.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zxin
 * @since 2023-05-11
 */
public interface IUserService extends IService<User> {
    User login(@RequestBody Map<String,String> map, HttpSession session);
    Map<Integer,User> getUserMap();
}
