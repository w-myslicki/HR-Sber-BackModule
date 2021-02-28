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
@Table(name = "users", schema = "public")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;

//    @OneToMany(mappedBy = "author")
//    private Set<PostEntity> posts;
    
//    @ManyToMany(mappedBy = "likedUsers")
//    private Set<PostEntity> likedPosts;
}
