package com.sber.BackModule.Controller;

import com.sber.BackModule.Entity.TagEntity;
import com.sber.BackModule.Enum.SortEnum;
import com.sber.BackModule.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")
    public ResponseEntity getAllPost(@RequestParam(value = "q", required = false) String q,
                                     @RequestParam(value = "sort", required = false) SortEnum sortEnum,
                                     @RequestParam(value = "tags", required = false) Set<TagEntity> tags) {

        return ResponseEntity.ok(postRepository.findAll());
    }


}
