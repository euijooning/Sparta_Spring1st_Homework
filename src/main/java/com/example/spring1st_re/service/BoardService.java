package com.example.spring1st_re.service;

import com.example.spring1st_re.repository.BoardRepository;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    } // ??? 이거 질문하자.


}

