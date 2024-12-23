package com.example.demo_12.Service;

import com.example.demo_12.Model.MyUser;
import com.example.demo_12.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;

    public void adduser(MyUser myUser) {

        myUser.setRole("USER");
        String hash = new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hash);
        authRepository.save(myUser);

    }


}
