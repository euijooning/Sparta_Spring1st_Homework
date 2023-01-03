package com.example.spring1st_re.dto;

import com.example.spring1st_re.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardResponse {
    private String title;
    private String writer;
    private String content;

    public BoardResponse(Board board) {
        this.title = board.getTitle();
        this.writer = board.getWriter();
        this.content = board.getContent();
    }
}
