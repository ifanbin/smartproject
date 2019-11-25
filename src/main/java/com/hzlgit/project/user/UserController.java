package com.hzlgit.project.user;

import cn.hutool.core.exceptions.StatefulException;
import cn.hutool.crypto.SecureUtil;
import com.hzlgit.project.config.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@Api(tags = {"用户管理"})
public class UserController {
    @PostMapping(value = "/sign-in", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "登录")
    public HashMap<String, String> signIn(String username, String password) {
        String md5 = SecureUtil.md5(password);
/*        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("username", username);
        List<User> users = userMapper.selectByExample(example);
        if (users.isEmpty()) {
            throw new StatefulException(HttpStatus.UNAUTHORIZED.value(), "不存在这个用户！");
        } else if (!md5.equals(users.get(0).getPassword())) {
            throw new StatefulException(HttpStatus.UNAUTHORIZED.value(), "用户密码错误！");
        }*/
        String token = JwtUtils.getToken(username);
        return new HashMap<String, String>() {{
            put("token", token);
        }};
    }
}
