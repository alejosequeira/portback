
package com.ejemplo.SpringBot.controller;

import com.ejemplo.SpringBot.model.User;
import com.ejemplo.SpringBot.service.IUserLoginService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "https://hosting-angularr.web.app")
public class UserLoginController {
    @Autowired
    private IUserLoginService loginService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user){
        loginService.addUser(user);
        return "salió todo bien";
    }

    @PostMapping("/api/login")
    public boolean checkLogin(@RequestBody User user){
        return loginService.checkLogin(user);
    }
    
    @GetMapping("/verUser")  
    public List<User> get(){
        return loginService.getUserLogin();
    }

}
