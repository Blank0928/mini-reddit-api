package com.example.mini_reddit_api.service;

import com.example.mini_reddit_api.model.Post;
import com.example.mini_reddit_api.model.Comment;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PostService {

    private final Map<Long, Post> posts = new HashMap<>();
    private final AtomicLong postIdCounter = new AtomicLong(1);
    private final AtomicLong commentIdCounter = new AtomicLong(1);

    // List all posts
    public List<Post> getAllPosts() {
        return new ArrayList<>(posts.values());
    }

    // Create a post
    public Post createPost(Post post) {
        long id = postIdCounter.getAndIncrement();
        post.setId(id);
        posts.put(id, post);
        return post;
    }

    // Get post by ID
    public Optional<Post> getPost(Long id) {
        return Optional.ofNullable(posts.get(id));
    }

    // Update post
    public Optional<Post> updatePost(Long id, Post updated) {
        Post existing = posts.get(id);
        if (existing != null) {
            existing.setTitle(updated.getTitle());
            existing.setContent(updated.getContent());
            existing.setAuthor(updated.getAuthor());
            return Optional.of(existing);
        }
        return Optional.empty();
    }

    // Delete post
    public boolean deletePost(Long id) {
        return posts.remove(id) != null;
    }

    // Add comment
    public Optional<Comment> addComment(Long postId, Comment comment) {
        Post post = posts.get(postId);
        if (post != null) {
            long commentId = commentIdCounter.getAndIncrement();
            comment.setId(commentId);
            post.getComments().add(comment);
            return Optional.of(comment);
        }
        return Optional.empty();
    }

    // Update comment
    public Optional<Comment> updateComment(Long postId, Long commentId, Comment updated) {
        Post post = posts.get(postId);
        if (post != null) {
            for (Comment c : post.getComments()) {
                if (c.getId().equals(commentId)) {
                    c.setContent(updated.getContent());
                    c.setAuthor(updated.getAuthor());
                    return Optional.of(c);
                }
            }
        }
        return Optional.empty();
    }

    // Delete comment
    public boolean deleteComment(Long postId, Long commentId) {
        Post post = posts.get(postId);
        if (post != null) {
            return post.getComments().removeIf(c -> c.getId().equals(commentId));
        }
        return false;
    }
}
