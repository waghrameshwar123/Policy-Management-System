package com.repository;

import com.entity.UserPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserPolicyRepository  extends JpaRepository<UserPolicy,Long> {
    @Query("select up from UserPolicy up where up.userId=?1")
    List<UserPolicy> findByUser(Long userId);

    UserPolicy save(UserPolicy userPolicy);

}
