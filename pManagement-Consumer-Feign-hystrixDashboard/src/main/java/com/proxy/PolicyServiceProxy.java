package com.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.domain.Policy;
import com.domain.User;
import com.fallback.PolicyServiceFallback;



@FeignClient(name="policy-service", fallback = PolicyServiceFallback.class)
public interface PolicyServiceProxy {
	
	@PostMapping(value = "/policies/")
	Policy save(Policy policy);
	
	@PostMapping(value = "/users/")
	User create(User user);
	
//	@GetMapping(value = "/policies/all", produces = {MediaType.APPLICATION_JSON_VALUE})
//	public List<Policy> findAll();
//	
	@GetMapping(value = "/policies/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Policy findById(@PathVariable("id") long id);
	
	
	

}
