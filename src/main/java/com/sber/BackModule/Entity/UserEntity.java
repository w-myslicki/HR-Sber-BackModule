package com.sber.BackModule.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password_hash")
    private String password;

    @CreatedDate
    @Column(name = "date_created")
    private Date dateCreated;

    @OneToMany(mappedBy = "userEntity") 
    private List<PostEntity> postEntities;
    
    @ManyToMany(mappedBy = "userLikes")
    private Set<PostEntity> likedPosts;
}
