package com.company.database;

import com.company.entity.Comment;
import com.company.mapper.CommentMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {

    private static final String INSERT_NEW_COMMENT = "INSERT INTO comments (author_id,message,post_id,created_at,approved) VALUES(?,?,?,?,?) ";
   
    private static final String SELECT_COMMENTS_WITH_POST_ID = "SELECT * FROM comments WHERE post_id=?";
    private static final String SELECT_UNAPPROVED_COMMENTS = "SELECT * FROM comments WHERE approved=0";

    private static final String DELETE_COMMENT_WITH_ID = "DELETE FROM comments WHERE id=?";

    private static final String EDIT_COMMENT_WITH_ID = "UPDATE comments SET message=? WHERE id=?";
    private static final String APPROVE_COMMENT = "UPDATE comments SET approved=1 WHERE id=?";


    public final JdbcTemplate jdbcTemplate;

    @Override
    public List<Comment> getCommentsFromPost(int postId) {
        return jdbcTemplate.query(SELECT_COMMENTS_WITH_POST_ID,
                new CommentMapper(), postId);
    }

    @Override
    public List<Comment> getUnapprovedComments() {
        return jdbcTemplate.query(SELECT_UNAPPROVED_COMMENTS, new CommentMapper());
    }

    @Override
    public void addComment(Comment comment) {
        jdbcTemplate.update(INSERT_NEW_COMMENT, comment.getAuthorId(),
                comment.getMessage(), comment.getPostId(),
                comment.getCreatedAt(), comment.getApproved());
    }

    @Override
    public void deleteComment(int commentId) {
        jdbcTemplate.update(DELETE_COMMENT_WITH_ID,
                commentId);
    }

    @Override
    public void editComment(Comment comment) {
        jdbcTemplate.update(EDIT_COMMENT_WITH_ID, comment.getMessage(), comment.getId());
    }

    @Override
    public void makeCommentApproved(int commentId) {
        jdbcTemplate.update(APPROVE_COMMENT,commentId);
    }
}
