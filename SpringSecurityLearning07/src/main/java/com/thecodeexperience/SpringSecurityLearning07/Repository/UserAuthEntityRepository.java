package com.thecodeexperience.SpringSecurityLearning07.Repository;

import com.thecodeexperience.SpringSecurityLearning07.Entity.UserAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAuthEntityRepository extends JpaRepository<UserAuthEntity,Long> {
    Optional<UserAuthEntity> findByUsername(String username);
}
