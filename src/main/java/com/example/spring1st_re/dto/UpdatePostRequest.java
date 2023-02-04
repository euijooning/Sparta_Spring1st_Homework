package com.example.spring1st_re.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdatePostRequest {
    private String title;
    private String writer;
    private String content;


    public UpdatePostRequest(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;

    }
}
