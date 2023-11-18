package com.emanuel.todolsit.domains;

import com.emanuel.todolsit.dto.ToDoListDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tarefa;

    private String descricao;

    private Integer prazo;

    private LocalDateTime deadLine;

    public ToDoList(ToDoListDTO data) {
        this.tarefa = data.tarefa();
        this.descricao = data.descricao();
        this.prazo = data.prazo();
    }
}
