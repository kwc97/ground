package com.ground.service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ground.dto.MemberDTO;
import com.ground.entity.Member;
import com.ground.entity.Post;
import com.ground.repository.BoardRepository;
import com.ground.repository.HomeRepository;
import com.ground.repository.MemberRepository;

@Service
public class UserService {
    
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private HomeRepository homeRepository;

    @Autowired
    private BoardRepository boardRepository;

    public Integer getUserIdByLogId(String logId) {
        Member member = memberRepository.findByLogId(logId);
        if (member != null) {
            return member.getUserId();
        }
        return null; // 사용자가 존재하지 않을 경우
    }

    public List<Post> getPostsByLogId(String log_id) {
        Integer userId = getUserIdByLogId(log_id);
        if (userId != null) {
            // 홈 테이블과 포스트 테이블을 조인하여 해당 사용자가 작성한 게시물을 가져옴
            return boardRepository.findByHomeMemberUserId(userId);
        }
        return null; // 사용자가 존재하지 않을 경우
    }
    
    public List<Post> searchUserPosts(String logId, String searchKeyword) {
        Integer userId = getUserIdByLogId(logId);
        if (userId != null) {
            // 사용자가 작성한 게시물을 검색하는 쿼리를 호출
            return boardRepository.findByHomeMemberUserIdAndTitleContaining(userId, searchKeyword);
        }
        return null;
    }
    
    public MemberDTO getMemberDTOByLogId(String logId) {
        Member member = memberRepository.findByLogId(logId);
        if (member != null) {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setImg_path(member.getImg_path());
            memberDTO.setText(member.getText());
            memberDTO.setNickname(member.getNickname());

            return memberDTO;
        }
        return null; // 사용자가 존재하지 않을 경우
    }
    
}
