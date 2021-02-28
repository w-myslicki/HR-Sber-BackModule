package com.sber.BackModule.Repository;

import com.sber.BackModule.Entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, Integer> {
    RoleEntity findByName(String name);
}
