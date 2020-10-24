package com.last.yj.controller;

import com.last.yj.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author yangjun
 */
@Slf4j
@CrossOrigin
@RequestMapping("user")
@RestController
@Api(tags = "登录接口")
public class EduUserController {

    @ApiOperation(value = "login", notes = "登录接口")
    @PostMapping("login")
    public ResponseResult login(@ApiParam(name = "username",value = "用户名",required = true)String username, @ApiParam(name = "password",value = "用户密码",required = true) String password) {
        log.info("user: {}",username,password);
        return ResponseResult.ok().data("token","admin");
    }

    @ApiOperation(value = "info", notes = "用户信息")
    @GetMapping("info")
    public ResponseResult getInfo() {
        return ResponseResult.ok().data("roles","[admin]").data("name","last").data("avatar","https://www.baidu.com/link?url=2zstrS6DpImBKbtiATo7cIzYRCQ7lZrkhOILIBpGOpb63FG07Umng1mGNPYMeqeRXmr7n0a1MoudsBTIBO_zWBrsLJEEKVP-6HaaBItRZbeoc-MIAlTiHDMV9LYUl63ECReJl2PU70Mr0zyTr_X-Q_WhJ-8CqLQRaKYPgdXPpz6BS2xSmMV8xxyZFuV_P4Eb26YgB53ZHXWKPz7ToJos6oPnpdVWUyU5lokS8uhn9ZEdqjYSxt19MsgXDanPHhZGgW_pNDSwElclVm60eYs9VAhA2JbhErY0CO4mL9klgmpSnKQZQULG9xvl9VwtGM-vO1XT-_JsesYCAZSa0duqZG8W0a8btM8kHxc8XG5Esi4quZmqRYec204lqZKqxC0wlNq76UVc29f61Pi6j-4XWvC9f2avHs9lF4KsByGHo_hHjL5bLgZzJa5oxi1ig0mo0EqDKGwQm_W-6HaEw53lSB1XEReWoCWM3GaSOD9SC4m-J7DYPeRvyEB7OeYWfbDdFt6_fXVoXnD0o-R7eVue2-GyOkbDz_czwUsg-0ZqoYfNdES5s-CIVA9rkbITS52GSi8Gt506gBaMXZ_jkhRN-m8HoEJ4jUCfuHTbCbNRyS26tPQajNxNPUVNoiVyhEhE&timg=&click_t=1603518391516&s_info=1903_937&wd=&eqid=de59be2700004bd9000000055f93bfb2");
    }
}
