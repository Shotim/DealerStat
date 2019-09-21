package com.company.database;

import com.company.entity.Post;
import com.company.mapper.PostMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private static final String INSERT_NEW_POST = "INSERT INTO posts (dealer_id) VALUES(?)";
    private static final String SELECT_ALL_POSTS_WITH_DEALER_ID = "SELECT * FROM posts WHERE dealer_id=?";
    private static final String SELECT_POST_WITH_ID = "SELECT * FROM posts WHERE id=?";
    private static final String SELECT_ALL_POSTS = "SELECT * FROM posts";
    private static final String DELETE_POST_WITH_ID = "DELETE FROM posts WHERE id=?";
    

    public final JdbcTemplate jdbcTemplate;

    @Override
    public List<Post> getAllPosts() {
        return jdbcTemplate.query(SELECT_ALL_POSTS,
                new PostMapper());
    }

    @Override
    public List<Post> getPostsOfDealer(int dealerId) {
        return jdbcTemplate.query(SELECT_ALL_POSTS_WITH_DEALER_ID,
                new PostMapper(), dealerId);
    }

    @Override
    public Post getPost(int postId) {
        return jdbcTemplate.queryForObject(SELECT_POST_WITH_ID,
                new PostMapper(), postId);
    }

    @Override
    public void addPost(Post post) {
        jdbcTemplate.update(INSERT_NEW_POST,
                post.getDealerId());
    }

    @Override
    public void deletePost(int postId) {
        jdbcTemplate.update(DELETE_POST_WITH_ID,
                postId);
    }
}
