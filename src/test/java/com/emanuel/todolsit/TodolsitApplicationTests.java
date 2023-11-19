package com.emanuel.todolsit;

import com.emanuel.todolsit.domains.ToDoList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

@ActiveProfiles("test")
@SpringBootTest
class TodolsitApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void createTaskTest() {

		ToDoList toDoList = new ToDoList();

		toDoList.setTarefa("Task");
		toDoList.setDescricao("description");
		toDoList.setPrazo(2);

		webTestClient
				.post()
				.uri("/todolist")
				.bodyValue(toDoList)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].tarefa").isEqualTo(toDoList.getTarefa())
				.jsonPath("$[0].descricao").isEqualTo(toDoList.getDescricao())
				.jsonPath("$[0].prazo").isEqualTo(toDoList.getPrazo());
	}


	@Test
	void failCreateTask() {

		ToDoList toDoList = new ToDoList();

		webTestClient
				.post()
				.uri("/todolist")
				.bodyValue(toDoList)
				.exchange()
				.expectStatus().isBadRequest();
	}
}
