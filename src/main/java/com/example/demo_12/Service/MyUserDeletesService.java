package com.example.demo_12.Service;

import com.example.demo_12.ApiResponse.ApiException;
import com.example.demo_12.Model.MyUser;
import com.example.demo_12.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDeletesService implements UserDetailsService {

    private final AuthRepository authRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myuser =authRepository.findByUsername(username);
        if(myuser == null){
            throw new ApiException("Wrong username or password");
        }
        return myuser;
    }
}
