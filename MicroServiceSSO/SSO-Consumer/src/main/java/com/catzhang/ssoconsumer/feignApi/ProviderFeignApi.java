package com.catzhang.ssoconsumer.feignApi;

import com.catzhang.ssoconsumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "provider")
public interface ProviderFeignApi {

    @PostMapping(value = "/user/checkName")
    public String checkName(@RequestParam(value = "un") String username);

    @PostMapping(value = "/user/addUser" )
    public String addUser(@RequestBody User user);

    @PostMapping(value = "/user/login" )
    public String loginUser(@RequestParam("un") String username,
                            @RequestParam("pwd") String password);

    @GetMapping(value = "/user/query/{ticket}")
    public String getTicket(@PathVariable(value = "ticket")String ticket);
}
