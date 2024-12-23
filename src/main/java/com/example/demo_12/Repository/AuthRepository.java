package com.example.demo_12.Repository;


import com.example.demo_12.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository  extends JpaRepository<MyUser, Integer> {

    MyUser findByUsername(String username);

    MyUser findMyUserById(Integer id);

}
