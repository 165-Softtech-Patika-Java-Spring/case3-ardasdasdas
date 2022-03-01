package com.softtech.bootcamp.case3.service;

import com.softtech.bootcamp.case3.converter.CommentMapper;
import com.softtech.bootcamp.case3.enums.errormessage.NotFoundErrorMessage;
import com.softtech.bootcamp.case3.exception.NotFoundException;
import com.softtech.bootcamp.case3.model.Comment;
import com.softtech.bootcamp.case3.model.User;
import com.softtech.bootcamp.case3.repository.CommentRepository;
import com.softtech.bootcamp.case3.repository.UserRepository;
import com.softtech.bootcamp.case3.response.comment.CommentResponse;
import com.softtech.bootcamp.case3.response.comment.CommentSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public List<CommentResponse> findCommentsByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new NotFoundException(NotFoundErrorMessage.USER_NOT_FOUND_BY_USERNAME_ERROR_MESSAGE)
        );
        Long userId = user.getId();
        List<Comment> commentList = commentRepository.findAllByUserId(userId);
        return CommentMapper.INSTANCE.toCommentResponseListFromCommentList(commentList);
    }

    public List<CommentResponse> findCommentsByProductId(Long productId) {
        List<Comment> commentList = commentRepository.findAllByProductId(productId);
        return CommentMapper.INSTANCE.toCommentResponseListFromCommentList(commentList);
    }

    public CommentResponse save(CommentSaveRequest commentSaveRequest) {
        Comment comment = CommentMapper.INSTANCE.toCommentFromCommentSaveRequest(commentSaveRequest);
        return CommentMapper.INSTANCE.toCommentResponseFromComment(commentRepository.save(comment));
    }

    public CommentResponse delete(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new NotFoundException(NotFoundErrorMessage.COMMENT_NOT_FOUND_BY_ID_ERROR_MESSAGE)
        );
        commentRepository.deleteById(id);
        return CommentMapper.INSTANCE.toCommentResponseFromComment(comment);
    }
}
