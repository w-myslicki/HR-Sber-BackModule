package com.sber.BackModule.Controller;

import com.sber.BackModule.Entity.PostEntity;
import com.sber.BackModule.Entity.TagEntity;
import com.sber.BackModule.Entity.UserEntity;
import com.sber.BackModule.Enum.SortEnum;
import com.sber.BackModule.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping()
    public List<PostEntity> getAllPost(@RequestParam(value = "q", required = false) String q,
                                     @RequestParam(value = "sort", required = false) SortEnum sortEnum,
                                     @RequestParam(value = "tags", required = false) Set<TagEntity> tags) {

        List<PostEntity> usersList = new ArrayList<>();
        postRepository.findAll().forEach(usersList::add);
        return usersList;
    }
    
    @PostMapping()
    public PostEntity createPost (@RequestBody PostEntity postEntity) {
        return postRepository.save(postEntity);
    }

    @GetMapping("/{id}")
    public ResponseEntity getPost(@PathVariable("id") int id) {
        Optional<PostEntity> entityOptional = postRepository.findById(id);
        if (entityOptional.isPresent()) {
            return ResponseEntity.ok(entityOptional.get());
        } else {
            return (ResponseEntity) ResponseEntity.notFound();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePost(@PathVariable("id") int id, @RequestBody PostEntity postEntity) {
        Optional<PostEntity> optionalPostEntity = postRepository.findById(id);
        if (optionalPostEntity.isPresent()) {
            PostEntity newPost = optionalPostEntity.get();
            newPost.setContent(postEntity.getContent());
            newPost.setTags(postEntity.getTags());
            newPost.setAuthor(postEntity.getAuthor());
            newPost.setCreatedAt(postEntity.getCreatedAt());

            return ResponseEntity.ok(postRepository.save(newPost));
        }
        return (ResponseEntity) ResponseEntity.noContent();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") int id) {
        try {
            postRepository.deleteById(id);
        } catch (Exception exception) {
            return new ResponseEntity<>("Fail to delete!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("User has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/{id}/likes")
    public ResponseEntity getLikes(@PathVariable("id") int id) {
        Optional<PostEntity> postEntity = postRepository.findById(id);
        if (postEntity.isPresent()) {
            return ResponseEntity.ok(postEntity.get().getLikedUsers());
        } else {
            return (ResponseEntity) ResponseEntity.notFound();
        }
    }

//    @PostMapping("/{id}/likes")
//    public ResponseEntity createLike(@PathVariable("id") int id) {
//        Optional<PostEntity> postEntity = postRepository.findById(id);
//        if (postEntity.isPresent()) {
//            PostEntity newPost = postEntity.get();
//            return ResponseEntity.ok();
//        } else {
//            return (ResponseEntity) ResponseEntity.notFound();
//        }
//    }
}
