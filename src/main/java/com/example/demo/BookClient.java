package com.example.demo;

import com.example.demo.persistence.entity.BookEntity;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "bookclient")
public interface BookClient {
    @GetMapping("libri/{personId}")
    List<BookEntity> getBooksByPersonId(@Param Long personId);
}
