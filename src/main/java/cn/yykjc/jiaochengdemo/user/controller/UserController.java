package cn.yykjc.jiaochengdemo.user.controller;

import cn.yykjc.jiaochengdemo.user.entity.UserEntity;
import cn.yykjc.jiaochengdemo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;
    //自动注入

    @ResponseBody
    @RequestMapping("/getAll")
    public List<UserEntity> getAll(Map map){
        return userService.getAll(map);
    }

    @RequestMapping("/delById")   //这里是用方法里的参数来接收客户前端的数据，不是用实体类来接收的
    public String delById(Integer id){
        userService.delById(id);
        return "redirect:/index.html";
    }

    //保存用户
    @RequestMapping("/save")
    @ResponseBody
    public String save(@RequestBody UserEntity userEntity){  //这里我们用实体类来接收前端客户传回来的数据，这样就不用在后端写封装数据的逻辑了，用实体类接收客户前端的数据，然后直接保存到数据库里

        System.out.println("用户注册 - " + userEntity.toString());
        userService.save(userEntity);
        return "success";
    }
    //测试一下改动代码后，再次上传GitHub，再次进行测试
}
