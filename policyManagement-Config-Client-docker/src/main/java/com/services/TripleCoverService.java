package com.services;

import com.entity.Policy;
import com.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component

public interface TripleCoverService {

    public boolean isAdmin(String userName);
    public boolean isAdminPasswordValid(String password);

    public User isValidUser(String userId);
    public boolean isUserPasswordValid(User user, String password);
	

}
