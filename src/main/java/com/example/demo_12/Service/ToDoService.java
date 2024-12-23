package com.example.demo_12.Service;


import com.example.demo_12.ApiResponse.ApiException;
import com.example.demo_12.Model.MyUser;
import com.example.demo_12.Model.ToDo;
import com.example.demo_12.Repository.AuthRepository;
import com.example.demo_12.Repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {


    private final AuthRepository authRepository;
    private final ToDoRepository toDoRepository;

    public ToDoService(AuthRepository authRepository, ToDoRepository toDoRepository) {
        this.authRepository = authRepository;
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> getMyToDo(Integer userId){
        MyUser myUser = authRepository.findMyUserById(userId);

        if (myUser == null) throw new ApiException("user not found");

        return toDoRepository.findAllByMyUser(myUser);
    }

    public void addToDo(Integer userId,ToDo toDo){
        MyUser myUser = authRepository.findMyUserById(userId);

        if (myUser == null) throw new ApiException("user not found");

        toDo.setMyUser(myUser);

        myUser.getToDos().add(toDo);


    }
}
