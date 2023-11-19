package com.emanuel.todolsit.domains;

import com.emanuel.todolsit.dto.ToDoListDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank
    private String tarefa;

    @NotBlank
    private String descricao;

    @NotNull
    private Integer prazo;

    private LocalDateTime deadLine;


    public ToDoList(ToDoListDTO data) {
        this.tarefa = data.tarefa();
        this.descricao = data.descricao();
        this.prazo = data.prazo();
    }
}
