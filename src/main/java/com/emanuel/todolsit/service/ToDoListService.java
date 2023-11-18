package com.emanuel.todolsit.service;

import com.emanuel.todolsit.domains.ToDoList;
import com.emanuel.todolsit.dto.ToDoListDTO;
import com.emanuel.todolsit.repository.ToDoListRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ToDoListService {

    @Autowired
    private ToDoListRepository toDoListRepository;

    @Transactional
    public ResponseEntity<ToDoList> saveTask(ToDoList toDoList){
        this.toDoListRepository.save(toDoList);
        return new ResponseEntity<>(toDoList, HttpStatus.OK);
    }

    public ToDoList createTask(ToDoListDTO data){

        ToDoList newTask = new ToDoList(data);
        newTask.setDeadLine(LocalDateTime.now().plusDays(newTask.getPrazo()));

        this.saveTask(newTask);

        return newTask;
    }

    public Page<ToDoList> findAllTasks(Pageable pageable){
        return this.toDoListRepository.findAll(pageable);
    }
}
