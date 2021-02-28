package com.loginregistration.loginregistration.repositories;

import com.loginregistration.loginregistration.models.Show;
import com.loginregistration.loginregistration.models.User;
import com.loginregistration.loginregistration.models.UserShow;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserShowRepository extends CrudRepository<UserShow, Long> {
    List<UserShow> findByShow(Show show);
    UserShow findByUser(User user);
}
