package com.example.demo_12.Controller;


import com.example.demo_12.ApiResponse.ApiResponse;
import com.example.demo_12.Model.MyUser;
import com.example.demo_12.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class MyUserController {

    private final AuthService authService;

    @PostMapping("/registr")
    public ResponseEntity<ApiResponse> addUser(@RequestBody @Valid MyUser myUser) {

        authService.adduser(myUser);

        return ResponseEntity.status(200).body(new ApiResponse("successfully added user"));

    }
}
