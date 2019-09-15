package com.company.service.post;

import com.company.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> findAllPosts();

    List<Post> findPostsOfDealer(int dealerId);

    Post findPost(int postId);

    void addPost(Post post);

    void removePost(int postId);
}
