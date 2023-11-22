package com.example.demo.business.impl;

import com.example.demo.*;
import com.example.demo.business.PersonBusiness;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.mapper.HobbyMapper;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.model.v1.CourseDTO;
import com.example.demo.persistence.entity.PersonEntity;
import com.example.demo.persistence.repository.CourseRepository;
import com.example.demo.persistence.repository.PersonRepository;
import com.example.demo.model.v1.BookDTO;
import com.example.demo.model.v1.HobbyDTO;
import com.example.demo.model.v1.PersonDTO;
import feign.Feign;
import feign.gson.GsonDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonBusinessImpl implements PersonBusiness {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private HobbyMapper hobbyMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<PersonDTO> getAll() {
        return personMapper.mapToDTOList(personRepository.findAll());
    }

    @Override
    public Page<PersonDTO> getPage(Integer page, Integer size) {
        Pageable pageWithElements = PageRequest.of(page, size);
        return personMapper.mapToDTOPage(personRepository.findAll(pageWithElements));
    }

    @Override
    public List<HobbyDTO> getHobbiesByPersonId(Long personId) {
        HobbyClient hobbyClient = Feign.builder()
                .decoder(new GsonDecoder())
                .target(HobbyClient.class, "http://localhost:8080");
        
        return hobbyMapper.mapToDTOList(hobbyClient.getHobbiesByPersonId(personId));
    }
    @Override
    public List<BookDTO> getBooksByPersonId(Long personId) {
        BookClient bookClient = Feign.builder()
                .decoder(new GsonDecoder())
                .target(BookClient.class, "http://localhost:8085");

        return bookMapper.mapToDTOList(bookClient.getBooksByPersonId(personId));
    }
    @Override
    public Page<PersonDTO> getPageWithSorting(Integer page, Integer size, String field, Boolean ascending) {
        if (field == null) {
            return getPage(page, size);
        }
        Sort.Direction direction = ascending ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageWithElementsSorted = PageRequest.of(page, size, Sort.by(direction, field));
        return personMapper.mapToDTOPage(personRepository.findAll(pageWithElementsSorted));
    }

    @Override
    public Page<PersonDTO> getPageWithFiltering(Integer page, Integer size, String iniziale) {
        Pageable pageWithElements = PageRequest.of(page, size);
        return personMapper.mapToDTOPage(personRepository.findByNomeStartingWithIgnoreCase(iniziale, pageWithElements));
    }

    @Override
    public Page<PersonDTO> getPageWithSortingAndFiltering(Integer page, Integer size, String field, Boolean ascending, String iniziale) {
        if (iniziale == null) {
            return getPageWithSorting(page, size, field, ascending);
        }
        if (field == null) {
            return getPageWithFiltering(page, size, iniziale);
        }
        Sort.Direction direction = ascending ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageWithElements = PageRequest.of(page, size, Sort.by(direction, field));
        return personMapper.mapToDTOPage(personRepository.findByNomeStartingWithIgnoreCase(iniziale, pageWithElements));
    }

    @Override
    public PersonDTO newPerson(PersonDTO newPerson) {
        PersonEntity newPersonEntity = personMapper.mapToEntity(newPerson);
        return personMapper.mapToDTO(personRepository.save(newPersonEntity));
    }

    @Override
    public PersonDTO getPersonById(Long id) {
        PersonEntity entity = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        return personMapper.mapToDTO(entity);
    }

    @Override
    public PersonDTO replacePerson(Long id, PersonDTO newPerson) {
        PersonEntity entity = personRepository.findById(id)
                .map(person -> {
                    person.setNome(newPerson.getNome());
                    person.setCognome(newPerson.getCognome());
                    person.setEta(newPerson.getEta());
                    return personRepository.save(person);
                }).orElseGet(() -> {
                    newPerson.setId(id);
                    return personRepository.save(personMapper.mapToEntity(newPerson));
                });
        return personMapper.mapToDTO(entity);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public List<PersonDTO> getPersonsByCourseId(Long courseid) {
        return personMapper.mapToDTOList(personRepository.findByCorsi_id(courseid));
    }

    @Override
    public List<CourseDTO> getCoursesByPersonId(Long personid) {
        return courseMapper.mapToDTOList(courseRepository.findByPersone_id(personid));
    }

    @Override
    public List<CourseDTO> getCoursesByPersonNomeAndCognome(String nome, String cognome) {
        Long id = personRepository.findByNomeAndCognome(nome, cognome).get(0).getId();
        return getCoursesByPersonId(id);
    }

    @Override
    public List<CourseDTO> getCoursesByPersonNomeAndCognomeInCommon(String nome, String cognome, String nome2, String cognome2) {
        if(nome2 == null || cognome2 == null) {
            return getCoursesByPersonNomeAndCognome(nome, cognome);
        }
        List<CourseDTO> List1 = getCoursesByPersonNomeAndCognome(nome, cognome);
        List<CourseDTO> List2 = getCoursesByPersonNomeAndCognome(nome2, cognome2);
        List1.retainAll(List2);

        return List1;
    }
}
