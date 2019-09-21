package com.company.database;

import com.company.entity.Post;

import java.util.List;

public interface PostRepository {

    List<Post> getAllPosts();

    List<Post> getPostsOfDealer(int dealerId);

    Post getPost(int postId);

    void addPost(Post post);

    void deletePost(int postId);
}
