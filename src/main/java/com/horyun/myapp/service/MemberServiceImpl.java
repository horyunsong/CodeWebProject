package com.horyun.myapp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.horyun.myapp.domain.MemberVO;
import com.horyun.myapp.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	MemberDAO dao;
	
	@Override
	public String getTime() {
		return dao.getTime();
	}

	@Override
	public void insertMember(MemberVO vo) {
		dao.insertMember(vo);
	}

	@Override
	public MemberVO readMember(String userid) throws Exception {
		return dao.readMember(userid);
	}

	@Override
	public MemberVO readWithPW(String userid, String userpw) throws Exception {
		return dao.readWithPW(userid, userpw);
	}

}
