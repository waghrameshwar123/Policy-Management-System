package com.domain;

import java.util.List;

public class Policy {


    private Long id;


    private String policyName;

 
    private String detailedName;

   
    private List<UserPolicy> userPolicies;

    public String getPolicyName() {
        return policyName;
    }

    public Policy(Long id, String policyName, String detailedName, List<UserPolicy> userPolicies) {
		super();
		this.id = id;
		this.policyName = policyName;
		this.detailedName = detailedName;
		this.userPolicies = userPolicies;
	}

	public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }


    public String getDetailedName() {
        return detailedName;
    }

    public void setDetailedName(String detailedName) {
        this.detailedName = detailedName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "id=" + id +
                ", policyName='" + policyName + '\'' +
                ", detailedName='" + detailedName + '\'' +
                '}';
    }





}
