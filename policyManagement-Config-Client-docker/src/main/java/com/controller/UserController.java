package com.controller;

import com.config.TripleCoverConfig;
import com.entity.User;
import com.entity.UserPolicy;
import com.repository.UserPolicyRepository;
import com.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserPolicyRepository userPolicyRepository;

    @Autowired
    TripleCoverConfig tripleCoverConfig;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * Postman test URL
     * http://localhost:8090/user/1
     * @param id - of the user
     * @return One User object.
     */
    @RequestMapping("/user/{id}")
    public User get(@PathVariable(value = "id") Long id) {
        logger.info("Id passed "+id);
        User user = userRepository.getOne(id);
        logger.info("User {}",user);
        return user;
    }

    /**
     * Example
     * http://localhost:8090/userid/Roger0915
     * @param userId
     * @return
     */

    @RequestMapping("/userid/{userId}")
    public User getOneUserByUserId(@PathVariable(value = "userId")String userId) {
        logger.info("User Id passed "+userId);
        if(tripleCoverConfig.getAdminUserName().equals(userId)) {
            User user = new User();
            user.setUserId(userId);
            user.setPassword(userId);
            user.setFirstName(userId);
            user.setLastName(userId);
            return user;
        }
        User user = userRepository.findByUserId(userId);
        logger.info("User {}",user);
        return user;

    }

    /**
     * Postman URL http://localhost:8090/users/all
     * @return all users...
     */

    @GetMapping("/all")
    public List<User> list(){
        return userRepository.findAll();
    }

    /**
     * POST URI http://localhost:8090/users/
     * Create new user
     * @param user
     *
     * To update pass
     *  {
     *         "id": 12,
     *         "userId": "test12",
     *         "firstName": "12 Tester first name",
     *         "lastName": "12 Tester Last name",
     *         "birthDate": "1988-01-12",
     *         "address": "tester street 12, tester city, tester state, 10001",
     *         "contactNumber": "+1 122-333-4444",
     *         "email": "tester12@testers.com",
     *         "password": "122-433p2d-"
     *     }
     *
     *     To create pass without ID
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody @Validated User user) {
        return userRepository.save(user);
    }

    /**
     * Get all the policy details for a given user
     *
     * To test user Rest API from postman use
     * http://localhost:8090/userPolicies/1
     * @param userId
     * @return
     */

    @RequestMapping("userPolicies/{id}")
    public List<UserPolicy> getUserPolicies(@PathVariable(value = "id") Long userId) {
        return userPolicyRepository.findByUser(userId);
    }
    
    

}
