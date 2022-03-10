package com.wyj.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Wuyj
 * @DateTime 2022-03-09 16:33
 * @Version 1.0
 */

@Controller
public class RequestController {

    //@Controller控制器,默认方法的返回是进行页面的跳转的
    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request) {
        request.setAttribute("msg", "成功了....");
        request.setAttribute("code", 200);
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute("msg") String msg,
                       @RequestAttribute("code") Integer code,
                       HttpServletRequest request) {
        Object msg1 = request.getAttribute("msg");

        HashMap<String, Object> map = new HashMap<>();
        map.put("req_msg", msg1);
        map.put("an_msg", msg);
        return map;
    }

    //1.请求路径:/cars/sell;low=34;brand=byd,audi,yd
    //2.SpringBoot默认是禁用了矩阵变量的功能
    //手动开启:需要定制化SpringMVC组件来实现
    //原理:对于路径的处理,使用UrlPathHelper进行解析,
    //其中removeSemicolonContent（移除分号内容）支持矩阵变量的
    //3.矩阵变量必须有url路径变量才能被解析
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand) {
        Map<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        return map;
    }
}
