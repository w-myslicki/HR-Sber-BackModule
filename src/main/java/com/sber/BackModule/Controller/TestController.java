package com.sber.BackModule.Controller;

import com.sber.BackModule.Entity.PostEntity;
import com.sber.BackModule.Entity.TagEntity;
import com.sber.BackModule.Enum.SortEnum;
import com.sber.BackModule.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/test")
public class TestController {

    @Autowired
    private PostRepository postRepository;

    public ResponseEntity getAllPost(@RequestParam(value = "q") String q,
                                     @RequestParam(value = "sort") SortEnum sortEnum,
                                     @RequestParam(value = "tags") List<TagEntity> tags) {

        List<PostEntity> postEntities = new ArrayList<>();
        Iterable<PostEntity> iterable = postRepository.findAll();
        iterable.forEach(postEntities::add);
        
        return ResponseEntity.ok(postEntities);
    }

}
