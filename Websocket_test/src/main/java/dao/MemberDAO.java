package dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Member;

@Repository
public class MemberDAO {
	
	private String strNameSpace = "MemberMapper";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	public Member getModel(Member member) {
		return sqlSession.selectOne(strNameSpace + ".getModel", member);
	}
}
