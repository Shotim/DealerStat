package com.company.service.post;


import com.company.database.DataBaseService;
import com.company.entity.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService{

    public DataBaseService dataBaseService;

    @Override
    public List<Post> findAllPosts() {
        return dataBaseService.getAllPosts();
    }

    @Override
    public List<Post> findPostsOfDealer(int dealerId) {
        return dataBaseService.getPostsOfDealer(dealerId);
    }

    @Override
    public Post findPost(int postId) {
        return dataBaseService.getPost(postId);
    }

    @Override
    public void addPost(Post post) {
        dataBaseService.addPost(post);
    }

    @Override
    public void removePost(int postId) {
        dataBaseService.deletePost(postId);
    }
}
