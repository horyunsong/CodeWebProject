package com.horyun.myapp.util;

import javax.inject.Inject;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.horyun.myapp.domain.MemberVO;
import com.horyun.myapp.persistence.MemberDAO;

public class MemberValidation implements Validator{
	//Spring에서 제공하는 Validation
	@Inject
	private MemberDAO dao;
	
	@Override
	public boolean supports(Class<?> arg0) {
		//타당한 상태인지 검사를 해서 true/false를 리턴한다
		return MemberVO.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		MemberVO member = (MemberVO) arg0;
		if(member.getUserid() == null || member.getUserid().trim().isEmpty()){
			arg1.rejectValue("userid", "required");
			//Errors arg1는 에러가 발생했을떄 수집한 정보
			//rejectValue는 세부적으로 키값을 검사, rejecct는 전체적으로 뭉뚱그려서
			//userid가 뭘 잘못했어? required인데 입력을 안했어. 반드시 넣을 수 있도록 유도하는것 
			//뭐가 잘못되었는지 표시정도만 
		}
		if(member.getUserpw() == null || member.getUserpw().trim().isEmpty()){
			arg1.rejectValue("userpw", "required");
		}
		
		try {
			dao.readWithPW(member.getUserid(), member.getUserpw());
		}
		catch(Exception err) {
			arg1.reject("login");
		}
	}
	

}
