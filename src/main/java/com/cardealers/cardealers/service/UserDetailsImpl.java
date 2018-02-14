package com.cardealers.cardealers.service;

import com.cardealers.cardealers.model.User;
import com.cardealers.cardealers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserDetailsImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s);
        HashSet<GrantedAuthority> hashSet = new HashSet<>();
        hashSet.add(new SimpleGrantedAuthority("USER"));
        if(user !=null) {
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), hashSet);
        } else {
            throw new UsernameNotFoundException("User inexistent");
        }

    }
}
