package com.example.person;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException() {
        super("Non ho trovato la persona cercata");
    }

    public PersonNotFoundException(Long id) {
        super("Non ho trovato la persona cercata con id " + id);
    }
}
