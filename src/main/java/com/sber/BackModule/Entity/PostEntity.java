package com.sber.BackModule.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Data
@Entity
@Table(name = "posts", schema = "public")
public class PostEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "content")
    private String content;

    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

//    @ManyToOne
//    @JoinColumn(name="author_id")
//    private UserEntity author;

//    @ManyToMany
//    @JoinTable(name = "posts_tags",
//               joinColumns = @JoinColumn(name = "tag_id"),
//               inverseJoinColumns = @JoinColumn(name = "post_id"))
//    private Set<TagEntity> tags;

//    @ManyToMany
//    @JoinTable(name = "posts_likes",
//               joinColumns = @JoinColumn(name = "post_id"),
//               inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private Set<UserEntity> likedUsers;
}
