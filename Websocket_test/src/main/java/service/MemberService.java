package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemberDAO;
import model.Member;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	
	public Member login(Member member) {
		Member result = dao.getModel(member);
		if(result == null) {
			return null; // 아이디 존재 x
		} else if(!member.getPassword().equals(result.getPassword())) {
			return null; // 비밀번호 다름
		} else {
			return result;
		}
	}
}
