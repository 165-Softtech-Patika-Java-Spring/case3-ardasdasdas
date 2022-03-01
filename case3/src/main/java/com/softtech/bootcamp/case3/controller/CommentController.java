package com.softtech.bootcamp.case3.controller;

import com.softtech.bootcamp.case3.model.Comment;
import com.softtech.bootcamp.case3.response.RestResponse;
import com.softtech.bootcamp.case3.response.comment.CommentResponse;
import com.softtech.bootcamp.case3.response.comment.CommentSaveRequest;
import com.softtech.bootcamp.case3.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/list/username")
    public ResponseEntity findCommentsByUsername(@RequestParam String username){
        return ResponseEntity.ok(RestResponse.of(commentService.findCommentsByUsername(username)));
    }

    @GetMapping("/list/product-id/{id}")
    public ResponseEntity  findCommentsByProductId(@RequestParam Long productId){
        return ResponseEntity.ok(RestResponse.of(commentService.findCommentsByProductId(productId)));
    }

    @PostMapping
    public ResponseEntity  save(@RequestBody CommentSaveRequest commentSaveRequest){
        return ResponseEntity.ok(RestResponse.of(commentService.save(commentSaveRequest)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity  save(@PathVariable Long id){
        return ResponseEntity.ok(RestResponse.of(commentService.delete(id)));
    }
}
