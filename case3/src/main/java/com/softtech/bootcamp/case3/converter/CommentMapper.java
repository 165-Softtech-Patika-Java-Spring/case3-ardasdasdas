package com.softtech.bootcamp.case3.converter;

import com.softtech.bootcamp.case3.model.Comment;
import com.softtech.bootcamp.case3.response.comment.CommentResponse;
import com.softtech.bootcamp.case3.response.comment.CommentSaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentResponse toCommentResponseFromComment(Comment comment);

    Comment toCommentFromCommentSaveRequest(CommentSaveRequest commentSaveRequest);

    List<CommentResponse> toCommentResponseListFromCommentList(List<Comment> commentList);
}
