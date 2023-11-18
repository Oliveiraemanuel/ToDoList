package com.emanuel.todolsit.controller;

import com.emanuel.todolsit.domains.ToDoList;
import com.emanuel.todolsit.dto.ToDoListDTO;
import com.emanuel.todolsit.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    public ResponseEntity<ToDoList> getAllTasks(@PageableDefault(page = 0, size = 10, sort = "deadLine", direction = Sort.Direction.ASC)
                                                    Pageable pageable){

        Page<ToDoList> toDoList = this.toDoListService.findAllTasks(pageable);
        return new ResponseEntity(toDoList, HttpStatus.OK);
    }
}
