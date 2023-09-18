package com.example.project.direction.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RequiredArgsConstructor
@RestController // controller임을 알려주는 표시
@RequestMapping("/api") // 이곳으로 들어오는 API주소를 mapping, /api주소로 받겠다(localhost:8080/api)
public class GetController {

    // localhost:8080/api/getMultiParameter?account=abcd&email=study@gmail.com&page=10
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam) {
        System.out.println(searchParam.getMemberKakaoId());
        System.out.println(searchParam.getName());
        System.out.println(searchParam.getAge());

        return searchParam; // 객체를 리턴하면 JSON 형식으로 반환된다.
    }

}


