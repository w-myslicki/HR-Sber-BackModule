package com.sber.BackModule.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name = "tags")
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private int id;

    @Column(name = "tag_name")
    private String tagName;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "posts_tags",
        joinColumns = @JoinColumn(name = "tag_id") ,
        inverseJoinColumns = @JoinColumn(name = "post_id"))
    private List<PostEntity> postEntities;
}
