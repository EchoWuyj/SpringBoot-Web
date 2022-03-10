package com.wyj.boot.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Author Wuyj
 * @DateTime 2022-03-09 11:06
 * @Version 1.0
 */

@RestController
public class HelloController {
    @GetMapping("/user")
    //@RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(@RequestParam("username") String name) {
        return "GET-张三";
    }

    @PostMapping("/user")
    //@RequestMapping(value = "/user",method = RequestMethod.POST)
    public String saveUser() {
        return "POST-张三";
    }

    @PutMapping("/user")
    //@RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser() {
        return "PUT-张三";
    }

    @DeleteMapping("/user")
    //@RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser() {
        return "DELETE-张三";
    }
}
