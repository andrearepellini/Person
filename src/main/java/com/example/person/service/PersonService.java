package com.example.person.service;

import com.example.person.model.v1.BookDTO;
import com.example.person.model.v1.CourseDTO;
import com.example.person.model.v1.HobbyDTO;
import com.example.person.model.v1.PersonDTO;
import org.springframework.data.domain.Page;

import java.util.List;

 public interface PersonService {
     List<PersonDTO> getAll();

     Page<PersonDTO> getPage(Integer page, Integer size);

     List<HobbyDTO> getHobbiesByPersonId(Long personId);

    List<BookDTO> getBooksByPersonId(Long personId);

     Page<PersonDTO> getPageWithSorting(Integer page, Integer size, String field, Boolean ascending);

     Page<PersonDTO> getPageWithFiltering(Integer page, Integer size, String iniziale);

     Page<PersonDTO> getPageWithSortingAndFiltering(Integer page, Integer size, String field, Boolean ascending, String iniziale);

     PersonDTO newPerson(PersonDTO newPerson);

     PersonDTO getPersonById(Long id);

     PersonDTO replacePerson(Long id, PersonDTO newPerson);

     void deletePerson(Long id);

     List<PersonDTO> getPersonsByCourseId(Long courseid);

     List<CourseDTO> getCoursesByPersonId(Long personid);

     List<CourseDTO> getCoursesByPersonNomeAndCognome(String nome, String cognome);

     List<CourseDTO> getCoursesByPersonNomeAndCognomeInCommon(String nome, String cognome, String nome2, String cognome2);
 }
