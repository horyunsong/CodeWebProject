package com.horyun.myapp.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.horyun.myapp.domain.BoardVO;

@Repository
public class BoardDaoImpl implements BoardDAO {
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE="com.horyun.mappers.boardMapper";

	@Override
	public void create(BoardVO vo) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".read", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		sqlSession.selectOne(NAMESPACE + ".delete", bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {

		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

}
