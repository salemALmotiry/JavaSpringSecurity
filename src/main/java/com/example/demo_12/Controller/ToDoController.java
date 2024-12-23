package com.example.demo_12.Controller;


import com.example.demo_12.ApiResponse.ApiResponse;
import com.example.demo_12.Model.MyUser;
import com.example.demo_12.Model.ToDo;
import com.example.demo_12.Service.ToDoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/todo")
@RequiredArgsConstructor
public class ToDoController {


    private final ToDoService toDoService;


    @GetMapping("/my-todo")
    public ResponseEntity getMyToDo(@AuthenticationPrincipal MyUser myUser){

        return ResponseEntity.status(200).body(toDoService.getMyToDo(myUser.getId()));
    }

    @PostMapping("/add")
    public ResponseEntity addToDO(@AuthenticationPrincipal MyUser myUser, @RequestBody @Valid ToDo toDo){

        toDoService.addToDo(myUser.getId(),toDo);
        return ResponseEntity.status(200).body(new ApiResponse("successfully added"));
    }
}
