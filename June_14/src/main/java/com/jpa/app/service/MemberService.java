package com.jpa.app.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.app.domain.Member;
import com.jpa.app.model.InterMemberRepository;

@Service
public class MemberService implements InterMemberService {

	@Autowired
	private InterMemberRepository memberRepository;
	
	@Override
	public Member getMember(String userId) {
		
		Member mvo = null;
		
		try {
			Optional<Member> member = memberRepository.findById(userId);
			mvo = member.get();
		} catch(NoSuchElementException e) {
			// 데이터가 없는 경우 
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return mvo;
	}

}
