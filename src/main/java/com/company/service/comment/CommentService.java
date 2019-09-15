package com.company.service.comment;

import com.company.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findCommentsFromPost(int postId);

    void addComment(Comment comment);

    void removeComment(int commentId);

    void editComment(Comment comment);
}
