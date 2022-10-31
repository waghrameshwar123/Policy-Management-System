package com.domain;

import java.time.LocalDate;

public class UserPolicy {

	
    private Long id;


    private Long policyId;


    private Long userId;


    private Double amountPaid;


    private LocalDate policyEndDate;


    private String valid;


    private User user;


    private Policy policy;

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public LocalDate getPolicyEndDate() {
        return policyEndDate;
    }

    public void setPolicyEndDate(LocalDate policyEndDate) {
        this.policyEndDate = policyEndDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    @Override
    public String toString() {
        return "UserPolicy{" +
                "id=" + id +
                ", amountPaid=" + amountPaid +
                ", policyEndDate=" + policyEndDate +
                ", user=" + user +
                ", policy=" + policy +
                ", valid=" + this.getValid() +
                '}';
    }

    /**
     *
     * @return "Yes" if the policy end date is before or equals today, "No" otherwise.
     *
     */
    public String getValid() {
        return this.policyEndDate.isAfter(LocalDate.now())  ? "Yes"
                : "No";
    }

    public void setValid(String valid) {
        this.valid = valid;
    }
}
