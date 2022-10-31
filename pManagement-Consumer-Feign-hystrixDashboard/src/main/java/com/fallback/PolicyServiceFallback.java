package com.fallback;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;


import com.domain.Policy;
import com.domain.User;

import com.proxy.PolicyServiceProxy;


@Component
public class PolicyServiceFallback implements PolicyServiceProxy{

	@Override
	public Policy save(Policy policy) {
		// TODO Auto-generated method stub
		
		
		return new Policy(10L, "SampleFallback", "SampleFallback", null);
	}

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		return new User();
	}

	@Override
	public Policy findById(long id) {
		// TODO Auto-generated method stub
		return new Policy(10L, "SampleFallback", "SampleFallback", null);
	}

//	@Override
//	public List<Policy> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Policy findById(long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
//	@Override
//	public List<Book> getAllBooks(){
//		return Arrays.asList(new Book());
//	}
//	@Override
//	public Book BookById(int id) {
//		return new Book(id,"SQL","sql.org",200);
//		
//	}

}
