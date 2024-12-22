package com.example.javaspringsecurity.Service;

import com.example.javaspringsecurity.Api.ApiException;
import com.example.javaspringsecurity.Model.MyUser;
import com.example.javaspringsecurity.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final AuthRepository authRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = authRepository.findMyUsersByUsername(username);
        if(myUser == null)throw new ApiException("Error: username or password is incorrect");

        return myUser;
    }
}
