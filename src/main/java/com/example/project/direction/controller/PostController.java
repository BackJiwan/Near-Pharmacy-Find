package com.example.project.direction.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.*;
@Slf4j
@RequiredArgsConstructor
@RestController // controller임을 알려주는 표시
@RequestMapping("/api") // 이곳으로 들어오는 API주소를 mapping, /api주소로 받겠다(localhost:8080/api)
public class PostController {

    @PostMapping("/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam) {
        log.info("[PostController postMethod] searchParam: {}", searchParam);
        return searchParam;
    }
    //http://localhost/
}