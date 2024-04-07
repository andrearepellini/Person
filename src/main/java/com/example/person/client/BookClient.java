package com.example.person.client;

import com.example.person.persistence.entity.BookEntity;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "bookclient")
public interface BookClient {
    @GetMapping("libri/{personId}")
    List<BookEntity> getBooksByPersonId(@Param Long personId);
}
