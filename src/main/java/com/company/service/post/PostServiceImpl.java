package com.company.service.post;


import com.company.database.PostRepository;
import com.company.entity.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService{
    
    public PostRepository postRepository;

    @Override
    public List<Post> findAllPosts() {
        return postRepository.getAllPosts();
    }

    @Override
    public List<Post> findPostsOfDealer(int dealerId) {
        return postRepository.getPostsOfDealer(dealerId);
    }

    @Override
    public Post findPost(int postId) {
        return postRepository.getPost(postId);
    }

    @Override
    public void addPost(Post post) {
        postRepository.addPost(post);
    }

    @Override
    public void removePost(int postId) {
        postRepository.deletePost(postId);
    }
}
