package com.company.database;

import com.company.entity.Comment;

import java.util.List;

public interface CommentRepository {

    List<Comment> getCommentsFromPost(int postId);

    List<Comment> getUnapprovedComments();

    void deleteComment(int commentId);

    void addComment(Comment comment);

    void editComment(Comment comment);

    void makeCommentApproved(int commentId);
}
