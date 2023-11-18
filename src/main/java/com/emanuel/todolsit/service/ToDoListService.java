package com.emanuel.todolsit.service;

import com.emanuel.todolsit.domains.ToDoList;
import com.emanuel.todolsit.dto.ToDoListDTO;
import com.emanuel.todolsit.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ToDoListService {

    @Autowired
    private ToDoListRepository toDoListRepository;

    public ResponseEntity<ToDoList> saveTask(ToDoList toDoList){
        this.toDoListRepository.save(toDoList);
        return new ResponseEntity<>(toDoList, HttpStatus.OK);
    }

    public ToDoList createTask(ToDoListDTO data){
        ToDoList newTask = new ToDoList();
        this.saveTask(newTask);
        return newTask;
    }
}
