package com.controller;

import com.entity.Policy;
import com.repository.PolicyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/policies")
public class PolicyController {
    @Autowired
    PolicyRepository policyRepository;
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * http://localhost:8090/policies/all
     * @return all policies for the admin
     */
    @GetMapping("/all")
    public List<Policy> list() {
        List<Policy>  policies= policyRepository.findAll();

        logger.info("Size of the policy {}", policies.size());

        for (Policy policy: policies) {
            logger.info("Policy {} ",policy);
        }
        return policies;
    };
    @GetMapping("/test")
    public List<Policy> testFew() {
        List<Policy>  policies=  new ArrayList<>();
        Policy policy = new Policy();
        policy.setPolicyName("test 1...");
        policies.add(policy);

        policy = new Policy();
        policy.setPolicyName("test 2...");
        policies.add(policy);

        policy = new Policy();
        policy.setPolicyName("test 3...");
        policies.add(policy);



        logger.info("Size of the policy {}", policies.size());

        return policies;
    };

    /**
     * http://localhost:8090/policies/6
     * @param id - of one policy
     * @return the policy queries
     */
    @GetMapping("/{id}")
    public Policy findById(@PathVariable("id") long id) {
        return policyRepository.getOne(id);
    }
    
//    @DeleteMapping("policydelete/{id}")
//    public int deleteById(@PathVariable("id") int id) {
//        return policyRepository.delete(id);
//    }
//    
//    @PutMapping("updatepolicy/{id}")
//    public Policy updatePolicy(@RequestBody Policy policy) {
//        return policyRepository.updatePolicy(policy);
//    }
    

    /**
     * Save policy
     */

    /**
     * Save a policy
     * @param policy
     * @return saved policy
     *{
     *     "id": 26,
     *     "policyName": "NotJustLandTest2 2",
     *     "detailedName": "2 22Test ..Policy For Boats and Ships"
     * }
     * POST
     * http://localhost:8090/policies/
     */

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Policy save(@RequestBody @Validated Policy policy) {
        return policyRepository.save(policy);
    }



}
