package com.sber.BackModule.Repository;

import com.sber.BackModule.Entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostEntity, Integer> { 
}
