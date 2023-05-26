//多线程获取、保存用户信息
package com.project.eIASbackend.common;

import com.project.documentretrievalmanagementsystem.dto.UserDto;

public class UserHolder {
    private static final ThreadLocal<UserDto> tl = new ThreadLocal<>();

    public static void saveUser(UserDto user){
        tl.set(user);
    }

    public static UserDto getUser(){
        return tl.get();
    }

    public static void removeUser(){
        tl.remove();
    }
}
