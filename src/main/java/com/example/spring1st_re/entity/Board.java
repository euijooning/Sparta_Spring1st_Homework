package com.example.spring1st_re.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String title;
    private String writer;
    private String password;
    private String content;

    public Board() {} // 기본 생성자는 반드시 있어야 한다.

    public Board(String title, String writer, String password, String content) {
        this.title = title;
        this.writer = writer;
        this.password = password;
        this.content = content;
    } // 게시판 생성

    public void update(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }


}