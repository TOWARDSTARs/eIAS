//用户管理控制器：注册、登录
package com.project.eIASbackend.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.project.eIASbackend.common.R;
import com.project.eIASbackend.dto.UserDto;
import com.project.eIASbackend.entity.User;
import com.project.eIASbackend.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zxin
 * @since 2023-05-11
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
@Api(tags = "用户管理")
public class UserController {
    @Autowired
    IUserService userService;

    @ApiOperation("注册或登录")
    @PostMapping("/login")
    public R<User> login(@RequestBody @ApiParam("userName和Password") Map<String, String> map, HttpSession session, ServletRequest servletRequest){
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("Authorization");
        User user = userService.login(map, session);
        if (user!=null){
            return R.success(user);
        }else{
            return R.error("登录失败");
        }
    }
}
