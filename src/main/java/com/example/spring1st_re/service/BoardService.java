package com.example.spring1st_re.service;

import com.example.spring1st_re.dto.BoardResponse;
import com.example.spring1st_re.dto.CreateBoardRequest;
import com.example.spring1st_re.entity.Board;
import com.example.spring1st_re.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.Optional;

@Service // 이게 없으면 서버가 안 뜬다.
public class BoardService {
    private final BoardRepository boardRepository;
    // Repository를 상속받은 이 인터페이스는 DB처럼 동작한다. DB에게 시킬 때 얘한테 시키면 된다.

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    } // ??? 이거 질문하자. => 이것도@RequiredArgsConstructor 쓰면 되나?

    @Transactional
    // 게시글 생성 로직
    public void createBoard(CreateBoardRequest createBoardRequest) {
        Board board = new Board(createBoardRequest.getTitle(), createBoardRequest.getWriter(), createBoardRequest.getPassword(), createBoardRequest.getContent());
        boardRepository.save(board);
    }
    @Transactional
    // 게시글 조회 로직
    public BoardResponse getBoard(Long boardId) {
       Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("id 없음"));
        return new BoardResponse(board);
    }
}

