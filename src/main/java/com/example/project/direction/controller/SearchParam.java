package com.example.project.direction.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Data // getter, setter 자동 생성
@AllArgsConstructor // 모든 매개변수를 가진 생성자가 추가됨
public class SearchParam {
    private String memberKakaoId;
    private String name;
    private int age;

}