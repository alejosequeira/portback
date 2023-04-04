
package com.ejemplo.SpringBot.repository;

import com.ejemplo.SpringBot.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends CrudRepository<User, Integer> {
    User findByMailUser(String mailUser);
   User findByPasswordUser (String passUser);
}
