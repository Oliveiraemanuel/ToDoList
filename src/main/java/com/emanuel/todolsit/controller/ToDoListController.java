package com.emanuel.todolsit.controller;

import com.emanuel.todolsit.domains.ToDoList;
import com.emanuel.todolsit.dto.ToDoListDTO;
import com.emanuel.todolsit.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todolist")
public class ToDoListController {

    @Autowired
    private ToDoListService toDoListService;

    @PostMapping
    public ResponseEntity<ToDoList> createTask(@RequestBody ToDoListDTO data){

        ToDoList newTask = new ToDoList();
        newTask = this.toDoListService.createTask(data);
        return new ResponseEntity<>(newTask, HttpStatus.OK);
    }
}
