package com.wyj.boot.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Wuyj
 * @DateTime 2022-03-09 15:04
 * @Version 1.0
 */

@RestController
public class ParameterTestController {

    //car/2/owner/zhangsan
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String name,
                                      @PathVariable Map<String, String> pv,
                                      //获取一个请求头(一个请求头以KV的形式出现)
                                      @RequestHeader("User-Agent") String userAgent,
                                      //获取当次的所有请求头
                                      @RequestHeader Map<String, String> header,
                                      //获取请求参数
                                      @RequestParam("age") Integer age,
                                      @RequestParam("inters") List<String> inters,
                                      @RequestParam Map<String, String> params,
                                      //获取Cookie值
                                      @CookieValue("_ga") String _ga,
                                      @CookieValue("_ga") Cookie cookie) {

        Map<String, Object> map = new HashMap<>();

//        map.put("id",id);
//        map.put("name",name);
//        map.put("pv",pv);
//        map.put("userAgent",userAgent);
//        map.put("headers",header);
        map.put("age", age);
        map.put("inters", inters);
        map.put("params", params);
        map.put("_ga", _ga);
        System.out.println(cookie.getName() + "===>" + cookie.getValue());
        return map;
    }

    //表单提交,使用Post方法
    @PostMapping("/save")
    public Map postMethod(@RequestBody String content) {
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        return map;
    }
}
