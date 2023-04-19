
package com.ejemplo.SpringBot.service;

import com.ejemplo.SpringBot.model.User;
import com.ejemplo.SpringBot.repository.UserLoginRepository;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserLoginService implements IUserLoginService{
     @Autowired
     private UserLoginRepository loginRepository;

     @Override
    public void addUser(User user){
        loginRepository.save(user);
    }
    

     @Override
    public boolean checkLogin(User user){
        User currentUser = loginRepository.findByMailUser(user.getMailUser());                 //ale@gmail.com
       return user. getPasswordUser().equals(currentUser. getPasswordUser());       //asdasd
     }
     @Override
    public List<User> getUserLogin(){
         return (List<User>) loginRepository.findAll();
    }
}
