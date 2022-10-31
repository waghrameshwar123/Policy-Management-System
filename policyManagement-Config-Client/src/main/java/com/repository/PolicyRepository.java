package com.repository;

import com.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {

    public Policy findByPolicyName(String policyName);
    public List<Policy> findAll();
    public Policy save(Policy policy);
 //   public int  delete(int id);
 //   public Policy updatePolicy(Policy policy);

}
