package com.example.spring1st_re.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteBoardRequest {

    private String password;

    public DeleteBoardRequest(String password) {
        this.password = password;
    }
}

