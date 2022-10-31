package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.domain.Policy;
import com.domain.User;
import com.proxy.PolicyServiceProxy;

@RestController
public class PolicyConsumerController {
	
	@Autowired
	private PolicyServiceProxy policyserviceProxy;
	

//	@GetMapping("/policies/all")
//	public List<Policy> list() {
//        List<Policy>  policies= policyserviceProxy.findAll();
//        return policies;
//    };
//	
	@GetMapping("/policies/{id}")
	public Policy getPolicyById(@PathVariable("id") long id) {
		Policy policy = policyserviceProxy.findById(id);
		return policy;
	}
	
	
	@PostMapping("/policies/")
    public Policy save(@RequestBody @Validated Policy policy) {
        return policyserviceProxy.save(policy);
    }
	
	@PostMapping("/users/")
    public User createUser(@RequestBody @Validated User user) {
        return policyserviceProxy.create(user);
    }
}
