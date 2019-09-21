package com.company.service.comment;

import com.company.database.CommentRepository;
import com.company.entity.Comment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService{
    
    public CommentRepository commentRepository;

    @Override
    public List<Comment> findCommentsFromPost(int postId) {
        return commentRepository.getCommentsFromPost(postId);
    }

    @Override
    public List<Comment> findUnapprovedComments() {
        return commentRepository.getUnapprovedComments();
    }

    @Override
    public void addComment(Comment comment) {
        commentRepository.addComment(comment);
    }

    @Override
    public void removeComment(int commentId) {
        commentRepository.deleteComment(commentId);
    }

    @Override
    public void editComment(Comment comment) {
        commentRepository.editComment(comment);
    }

    @Override
    public void approveComment(int commentId) {
        commentRepository.makeCommentApproved(commentId);
    }
}
