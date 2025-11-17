package com.thecodeexperience.SpringSecurityLearning05.Service;

import com.thecodeexperience.SpringSecurityLearning05.Entity.UserAuthEntity;
import com.thecodeexperience.SpringSecurityLearning05.Repository.UserAuthEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthEntityService implements UserDetailsService {

    @Autowired
    private UserAuthEntityRepository userAuthEntityRepository;

    public UserDetails saveUser(UserAuthEntity userAuthEntity){
        return userAuthEntityRepository.save(userAuthEntity);
    }

    @Override
    public UserAuthEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAuthEntityRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("user not found"));
    }
}
