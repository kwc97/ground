package com.ground.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ground.entity.Home;
import com.ground.repository.HomeRepository;

@Service
public class HomeService {
    @Autowired
    private HomeRepository homeRepository;

    public Home findByUserId(Integer userId) {
        return homeRepository.findByMemberUserId(userId);
    }
}