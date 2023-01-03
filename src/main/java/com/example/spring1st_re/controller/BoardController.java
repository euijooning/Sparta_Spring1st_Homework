package com.example.spring1st_re.controller;

import com.example.spring1st_re.dto.CreateBoardRequest;
import com.example.spring1st_re.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/api/posts")
    //CreateBoardRequest 의 값을 전달 받음.
    public void createBoard(@RequestBody CreateBoardRequest createBoardRequest) {
        boardService.createBoard(createBoardRequest);
    }

}