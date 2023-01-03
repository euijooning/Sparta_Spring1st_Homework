package com.example.spring1st_re.controller;

import com.example.spring1st_re.dto.BoardResponse;
import com.example.spring1st_re.dto.CreateBoardRequest;
import com.example.spring1st_re.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/api/posts")
    //CreateBoardRequest 의 값을 전달 받음.
    public void createBoard(@RequestBody CreateBoardRequest createBoardRequest) {
        boardService.createBoard(createBoardRequest);
    }

    ///api/posts/1
    @GetMapping("/api/posts/{boardId}")
    public BoardResponse getBoard(@PathVariable Long boardId) {
      return boardService.getBoard(boardId);
    }

}