package com.company.service.comment;

import com.company.database.DataBaseService;
import com.company.entity.Comment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService{

    public DataBaseService dataBaseService;

    @Override
    public List<Comment> findCommentsFromPost(int postId) {
        return dataBaseService.getCommentsFromPost(postId);
    }

    @Override
    public void addComment(Comment comment) {
        dataBaseService.addComment(comment);
    }

    @Override
    public void removeComment(int commentId) {
        dataBaseService.deleteComment(commentId);
    }

    @Override
    public void editComment(Comment comment) {
        dataBaseService.editComment(comment);
    }
}
