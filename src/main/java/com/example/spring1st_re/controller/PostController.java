package com.example.spring1st_re.controller;

import com.example.spring1st_re.dto.PostResponse;
import com.example.spring1st_re.dto.CreatePostRequest;
import com.example.spring1st_re.dto.DeletePostRequest;
import com.example.spring1st_re.dto.UpdatePostRequest;
import com.example.spring1st_re.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // 게시물 생성
    @PostMapping("/api/posts")
    //CreateBoardRequest 의 값을 전달 받음.
    public void createPost(@RequestBody CreatePostRequest createPostRequest) {
        postService.createPost(createPostRequest);
    }

    // 전체 게시물 조회
    @GetMapping("/api/posts")
    public List<PostResponse> getPostList() {
        return postService.getPostList();
    }

    // 게시물 1개 조회
    ///api/posts/1
    @GetMapping("/api/posts/{postId}")
    public PostResponse getPost(@PathVariable Long postId) {
      return postService.getPost(postId);
    }

    // 게시물 1개 수정
    @PutMapping("/api/posts/{postId}")
    public void updatePost(@PathVariable Long postId, @RequestBody UpdatePostRequest updatePostRequest) {
        postService.updatePost(postId, updatePostRequest);
    }

    // 게시물 삭제
    @DeleteMapping("/api/posts/{postId}")
    public void deletePost(@PathVariable Long postId, @RequestBody DeletePostRequest deletePostRequest) {
        postService.deletePost(postId, deletePostRequest);
    }
}