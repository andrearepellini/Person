package com.example.person.controller;

import com.example.person.api.v1.PersonControllerApi;
import com.example.person.service.PersonService;
import com.example.person.model.v1.BookDTO;
import com.example.person.model.v1.CourseDTO;
import com.example.person.model.v1.HobbyDTO;
import com.example.person.model.v1.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonControllerApiImpl implements PersonControllerApi {
    @Autowired
    private PersonService personService;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return PersonControllerApi.super.getRequest();
    }

    @Override
    public ResponseEntity<List<HobbyDTO>> getHobbiesByPersonId(Long personId) {
        return new ResponseEntity<>(personService.getHobbiesByPersonId(personId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Page> getPageWithSortingAndFiltering(Integer page, Integer size, String field, Boolean ascending, String iniziale) {
        return new ResponseEntity<>(personService.getPageWithSortingAndFiltering(page, size, field, ascending, iniziale), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deletePerson(Long id) {
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<BookDTO>> getBooksByPersonId(Long personId) {
        return new ResponseEntity<>(personService.getBooksByPersonId(personId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CourseDTO>> getCoursesByPersonId(Long personid) {
        return new ResponseEntity<>(personService.getCoursesByPersonId(personid), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CourseDTO>> getCoursesByPersonNomeAndCognomeInCommon(String nome, String cognome, String nome2, String cognome2) {
        return new ResponseEntity<>(personService.getCoursesByPersonNomeAndCognomeInCommon(nome, cognome, nome2, cognome2), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PersonDTO> getPersonById(Long id) {
        return new ResponseEntity<>(personService.getPersonById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PersonDTO> newPerson(PersonDTO personDTO) {
        return new ResponseEntity<>(personService.newPerson(personDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PersonDTO> replacePerson(Long id, PersonDTO personDTO) {
        return new ResponseEntity<>(personService.replacePerson(id, personDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PersonDTO>> getPersonsByCourseId(Long courseid) {
        return new ResponseEntity<>(personService.getPersonsByCourseId(courseid), HttpStatus.OK);
    }
}
