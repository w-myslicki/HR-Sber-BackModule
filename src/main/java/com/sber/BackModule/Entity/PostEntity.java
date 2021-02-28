package com.sber.BackModule.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Setter;
import lombok.Getter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="author_id")
    @JsonIgnoreProperties({ "posts", "likedPosts" })
    private UserEntity author;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "posts_tags",
               joinColumns = @JoinColumn(name = "tag_id"),
               inverseJoinColumns = @JoinColumn(name = "post_id"))
    @JsonIgnoreProperties({ "posts" })
    private Set<TagEntity> tags;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "posts_likes",
               joinColumns = @JoinColumn(name = "post_id"),
               inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonIgnoreProperties({ "posts", "likedPosts" })
    private Set<UserEntity> likedUsers;
}
