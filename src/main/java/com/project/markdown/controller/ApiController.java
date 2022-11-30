package com.project.markdown.controller;

import com.project.markdown.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ApiController {
    private final ApiService apiService;

    /* 게시글 목록 불러오는 API */
    @GetMapping("/api/list")
    public String getApis() {
        return apiService.getList();
    }
}
