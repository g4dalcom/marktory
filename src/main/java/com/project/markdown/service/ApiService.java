package com.project.markdown.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Service
public class ApiService {

    String BASE_URL = "https://www.tistory.com/apis/post/list";
    String TOKEN = "f02ca9c8e76d412d7a83110e2e1a0c0c_4c861f4361f633643538f53ca4089966";

    private final WebClient webClient = WebClient.builder()
                .baseUrl(BASE_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();


    /* 블로그 게시글 1페이지 불러오기 */
    public String getList() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("access_token", TOKEN)
                        .queryParam("output", "application/json")
                        .queryParam("blogName", "g4daclom")
                        .queryParam("page", 1)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}
