package pl.marek.todoist.domain.todo

import pl.marek.todoist.domain.todo.Todo

class TodoMotherObject {

    static String ID = UUID.randomUUID().toString()
    static String EMAIL = "test@testowy.pl"
    static String FIRST_NAME = "John"
    static String LAST_NAME = "Wick"
    static String CONTENT = "Kill them all"

    static Todo aTodo() {
        Todo.builder()
                .id(ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .email(EMAIL)
                .content(CONTENT)
                .status(Todo.Status.PENDING)
                .build()
    }

    static Todo aTodo(String id) {
        Todo.builder()
                .id(id)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .email(EMAIL)
                .content(CONTENT)
                .status(Todo.Status.PENDING)
                .build()
    }
}
