//LOGIN_USER_KEY: 表示用户登录信息在 Redis 中的键值前缀。在该代码中，键的格式为 "login:token:{token}"，其中 {token} 是具体的用户登录令牌。
//LOGIN_USER_TTL: 表示用户登录信息在 Redis 中的过期时间，以分钟为单位。在该代码中，过期时间为 30 分钟。
package com.project.eIASbackend.utils;

public class RedisConstants {
    public static final String LOGIN_USER_KEY = "login:token:";
    public static final Long LOGIN_USER_TTL = 30L;
}
