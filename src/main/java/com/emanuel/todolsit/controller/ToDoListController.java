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

import java.time.LocalDateTime;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<ToDoList> getTaskById(@PathVariable (value = "id") Long id) throws Exception {
        Optional<ToDoList> toDoListOptional = toDoListService.findById(id);

        return new ResponseEntity(toDoListOptional, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ToDoList> deleteTaskById(@PathVariable (value = "id") Long id) throws Exception {

        Optional<ToDoList> toDoListOptional = toDoListService.findById(id);

        this.toDoListService.delete(toDoListOptional.get());

        return new ResponseEntity(toDoListOptional, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoList> updateTask(@PathVariable (value = "id") Long id,
                                               @RequestBody ToDoListDTO data) throws Exception {

        Optional<ToDoList> taskOptional = toDoListService.findById(id);

        ToDoList task = new ToDoList();
        task.setId(taskOptional.get().getId());
        task.setTarefa(data.tarefa());
        task.setDescricao(data.descricao());
        task.setPrazo(data.prazo());
        task.setDeadLine(LocalDateTime.now().plusDays(task.getPrazo()));

        return new ResponseEntity<>(task, HttpStatus.OK);
    }


}
