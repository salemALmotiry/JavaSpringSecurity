package com.example.demo_12.Repository;

import com.example.demo_12.Model.MyUser;
import com.example.demo_12.Model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo,Integer> {

    ToDo findToDoById(Integer id);

    List<ToDo> findAllByMyUser(MyUser myUser);
}
