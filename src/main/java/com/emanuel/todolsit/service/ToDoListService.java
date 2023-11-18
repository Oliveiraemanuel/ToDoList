package com.emanuel.todolsit.service;

import com.emanuel.todolsit.domains.ToDoList;
import com.emanuel.todolsit.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

@Service
public class ToDoListService {

    @Autowired
    private ToDoListRepository toDoListRepository;

    public ResponseEntity<ToDoList> saveTaks(ToDoList toDoList){
        this.toDoListRepository.save(toDoList);
        return new ResponseEntity<>(toDoList, HttpStatus.OK);
    }
}
