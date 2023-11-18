package com.emanuel.todolsit.repository;

import com.emanuel.todolsit.domains.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
}
