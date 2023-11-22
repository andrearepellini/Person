package com.example.demo.controller.impl;

import com.example.demo.api.v1.PersonControllerApi;
import com.example.demo.business.PersonBusiness;
import com.example.demo.model.v1.BookDTO;
import com.example.demo.model.v1.CourseDTO;
import com.example.demo.model.v1.HobbyDTO;
import com.example.demo.model.v1.PersonDTO;
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
    private PersonBusiness personBusiness;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return PersonControllerApi.super.getRequest();
    }

    @Override
    public ResponseEntity<List<HobbyDTO>> getHobbiesByPersonId(Long personId) {
        return new ResponseEntity<>(personBusiness.getHobbiesByPersonId(personId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Page> getPageWithSortingAndFiltering(Integer page, Integer size, String field, Boolean ascending, String iniziale) {
        return new ResponseEntity<>(personBusiness.getPageWithSortingAndFiltering(page, size, field, ascending, iniziale), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deletePerson(Long id) {
        personBusiness.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<BookDTO>> getBooksByPersonId(Long personId) {
        return new ResponseEntity<>(personBusiness.getBooksByPersonId(personId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CourseDTO>> getCoursesByPersonId(Long personid) {
        return new ResponseEntity<>(personBusiness.getCoursesByPersonId(personid), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CourseDTO>> getCoursesByPersonNomeAndCognomeInCommon(String nome, String cognome, String nome2, String cognome2) {
        return new ResponseEntity<>(personBusiness.getCoursesByPersonNomeAndCognomeInCommon(nome, cognome, nome2, cognome2), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PersonDTO> getPersonById(Long id) {
        return new ResponseEntity<>(personBusiness.getPersonById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PersonDTO> newPerson(PersonDTO personDTO) {
        return new ResponseEntity<>(personBusiness.newPerson(personDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PersonDTO> replacePerson(Long id, PersonDTO personDTO) {
        return new ResponseEntity<>(personBusiness.replacePerson(id, personDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PersonDTO>> getPersonsByCourseId(Long courseid) {
        return new ResponseEntity<>(personBusiness.getPersonsByCourseId(courseid), HttpStatus.OK);
    }
}
