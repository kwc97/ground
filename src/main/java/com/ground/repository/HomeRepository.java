package com.ground.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ground.entity.Home;

@Repository
public interface HomeRepository extends JpaRepository<Home, Integer> {
    Home findByMemberUserId(Integer userId);
}