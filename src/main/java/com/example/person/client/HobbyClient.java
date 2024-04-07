package com.example.person.client;

import com.example.person.persistence.entity.HobbyEntity;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface HobbyClient {
    @RequestLine("GET /hobbies/{personId}")
    List<HobbyEntity> getHobbiesByPersonId(@Param Long personId);
}
