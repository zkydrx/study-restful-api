package com.mystudy.spring.api;

import com.mystudy.spring.domain.User;
import com.mystudy.spring.exception.NotFoundException;
import com.mystudy.spring.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @ApiOperation(value="获取用户列表", notes="获取用户列表")
    @GetMapping(value = "/users")
    public List<User> getUserList()
    {
        return userService.getUserList();
    }

    @ApiOperation(value="添加用户", notes="添加用户")
    @PostMapping(value = "/users")
    public Object addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @ApiOperation(value="获取用户信息", notes="根据id获取用户信息")
    @GetMapping(value = "/users/{id}")
    public Object getUser(@PathVariable("id") String id) throws NotFoundException
    {
        return userService.getUser(id);
    }

    @ApiOperation(value="删除用户", notes="根据id删除用户")
    @DeleteMapping(value = "/users/{id}")
    public void deleteUser(@PathVariable("id") String id)
    {
        userService.deleteUser(id);
    }

    @ApiOperation(value="更新用户", notes="更新用户")
    @PatchMapping(value = "/users/{id}")
    public User updateUser(@PathVariable("id") String id, @RequestBody User user)
    {
        return userService.update(id, user);
    }


    @ApiOperation(value="测试")
    @GetMapping(value = "/test")
    public String test()
    {
        return "test ok!";
    }
}
