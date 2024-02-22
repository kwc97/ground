package com.ground;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ground.dto.MemberDTO;
import com.ground.mapper.MemberMapper;

@SpringBootTest
public class MapperTests {

	@Autowired
	private MemberMapper memberMapper;
	
}
