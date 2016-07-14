package com.horyun.myapp.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.horyun.myapp.domain.MemberVO;

@Repository//bean없어도 생성되는 
public class MemberDaoImpl implements MemberDAO {
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE="com.horyun.mappers.memberMapper";
	//memberMapper.xml에 있는 mapper namespace의 것을 가져온다
	
	@Override
	public String getTime() {
		return sqlSession.selectOne(NAMESPACE + ".getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(NAMESPACE + ".insertMember", vo);
	}

	@Override
	public MemberVO readMember(String userid) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".readMember");
	}

	@Override
	public MemberVO readWithPW(String userid, String userpw) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		return sqlSession.selectOne(NAMESPACE + ".readMember", paramMap);
	}

}
