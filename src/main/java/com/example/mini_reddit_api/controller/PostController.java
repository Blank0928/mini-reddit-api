package com.example.mini_reddit_api.controller;

import com.example.mini_reddit_api.model.Post;
import com.example.mini_reddit_api.model.Comment;
import com.example.mini_reddit_api.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:5173") // allow your frontend
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<Post> getAll() {
        return service.getAllPosts();
    }

    @PostMapping
    public Post create(@RequestBody Post post) {
        return service.createPost(post);
    }

    @GetMapping("/{id}")
    public Post get(@PathVariable Long id) {
        return service.getPost(id).orElseThrow(() -> new RuntimeException("Post not found"));
    }

    @PutMapping("/{id}")
    public Post update(@PathVariable Long id, @RequestBody Post post) {
        return service.updatePost(id, post).orElseThrow(() -> new RuntimeException("Post not found"));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        if (!service.deletePost(id)) throw new RuntimeException("Post not found");
    }

    @PostMapping("/{id}/comments")
    public Comment addComment(@PathVariable Long id, @RequestBody Comment comment) {
        return service.addComment(id, comment).orElseThrow(() -> new RuntimeException("Post not found"));
    }

    @PutMapping("/{postId}/comments/{commentId}")
    public Comment updateComment(@PathVariable Long postId, @PathVariable Long commentId, @RequestBody Comment comment) {
        return service.updateComment(postId, commentId, comment).orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    @DeleteMapping("/{postId}/comments/{commentId}")
    public void deleteComment(@PathVariable Long postId, @PathVariable Long commentId) {
        if (!service.deleteComment(postId, commentId)) throw new RuntimeException("Comment not found");
    }
}
