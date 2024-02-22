package com.ground.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ground.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member findByLogId(String logId);
}