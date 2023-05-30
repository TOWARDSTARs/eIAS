package service;

import com.project.eIASbackend.entity.User;
import com.project.eIASbackend.exception.HaveDisabledException;
import com.project.eIASbackend.exception.PasswordWrongException;
import com.project.eIASbackend.mapper.UserMapper;
import com.project.eIASbackend.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mock.web.MockHttpSession;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class IUserServiceTest {

    @InjectMocks
    private UserServiceImpl userServiceImpl;
    @Mock
    private UserMapper userMapper;
    @Mock
    private StringRedisTemplate stringRedisTemplate;
    private MockHttpSession session = new MockHttpSession();
    //测试新用户登录

    //测试禁用用户登录
    @Test
    public void login_should_throw_exception_when_user_is_disabled() {
        // Given
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("userName", "myy");
        requestBody.put("password", "51888");
        User user = new User();
        user.setUserName("myy");
        user.setPassword("51888");
        user.setStatus(0);
        Mockito.when(userMapper.selectOne(ArgumentMatchers.any())).thenReturn(user);
        // When & Then
        Assertions.assertThrows(HaveDisabledException.class, () -> userServiceImpl.login(requestBody, session));
    }



    //测试用户登录但是密码错误
    @Test
    public void login_should_throw_exception_when_password_is_wrong() {
        // Given
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("userName", "pxm");
        requestBody.put("password", "123456");
        User user = new User();
        user.setUserName("pxm");
        user.setPassword("12345");
        user.setStatus(1);
        Mockito.when(userMapper.selectOne(ArgumentMatchers.any())).thenReturn(user);
        // When & Then
        Assertions.assertThrows(PasswordWrongException.class, () -> userServiceImpl.login(requestBody, session));

    }
}