package com.example.demo;

import com.example.demo.persistence.entity.HobbyEntity;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface HobbyClient {
    @RequestLine("GET /hobbies/{personId}")
    List<HobbyEntity> getHobbiesByPersonId(@Param Long personId);
}
