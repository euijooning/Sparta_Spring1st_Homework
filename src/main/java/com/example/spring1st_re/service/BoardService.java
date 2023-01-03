package com.example.spring1st_re.service;

import com.example.spring1st_re.dto.BoardResponse;
import com.example.spring1st_re.dto.CreateBoardRequest;
import com.example.spring1st_re.dto.UpdateBoardRequest;
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

    // 게시글 수정 로직
    @Transactional
    public void updateBoard(Long boardId, UpdateBoardRequest updateBoardRequest) {
        Board boardSaved = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("id 없음"));
    //    boardSaved.update(updateBoardRequest.getTitle(), updateBoardRequest.getWriter(), updateBoardRequest.getContent());
    //  추가요건 : 수정요청 시 수정 데이터와 비밀번호를 함께 보내서 서버에서 비밀번호 일치 여부 확인 후 업데이트 해라.
    // 이게 앞서 넣어놓은(Board 에다가) 비밀번호 유효성 검사.
        if(boardSaved.isValidPassword(updateBoardRequest.getPassword())) {
            boardSaved.update(updateBoardRequest.getTitle(), updateBoardRequest.getWriter(), updateBoardRequest.getContent());
            boardRepository.save(boardSaved);
        } else {
            throw new IllegalArgumentException("패스워드가 틀렸습니다!");
        }

    }
}
