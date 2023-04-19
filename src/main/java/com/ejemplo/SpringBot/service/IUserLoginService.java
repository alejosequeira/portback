
package com.ejemplo.SpringBot.service;

import com.ejemplo.SpringBot.model.User;
import java.util.List;


public interface IUserLoginService {
    public void addUser(User user);
    public boolean checkLogin(User user);
    public List<User> getUserLogin();
}
