package com.softtech.bootcamp.case3.response.comment;

import lombok.Data;

@Data
public class CommentResponse {

    private Long id;
    private String text;
    private Long userId;
    private Long productId;
}
