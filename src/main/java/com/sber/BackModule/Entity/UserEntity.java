package com.sber.BackModule.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "public")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "created_at")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "author", "likedUsers" })
    private Set<PostEntity> posts;

    @ManyToMany(mappedBy = "likedUsers", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "author", "likedUsers" })
    private Set<PostEntity> likedPosts;


}
