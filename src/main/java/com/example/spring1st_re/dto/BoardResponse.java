package com.example.spring1st_re.dto;

import com.example.spring1st_re.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardResponse {
    private String title;
    private String writer;
    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;


    public BoardResponse(Board board) {
        this.title = board.getTitle();
        this.writer = board.getWriter();
        this.content = board.getContent();
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
    }
}
