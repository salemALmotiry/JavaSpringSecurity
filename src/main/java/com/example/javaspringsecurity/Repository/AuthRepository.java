package com.example.javaspringsecurity.Repository;

import com.example.javaspringsecurity.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<MyUser,Integer> {

    MyUser findMyUsersByUsername(String username);
}
