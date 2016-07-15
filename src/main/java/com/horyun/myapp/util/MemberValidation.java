package com.horyun.myapp.util;

import javax.inject.Inject;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.horyun.myapp.domain.MemberVO;
import com.horyun.myapp.persistence.MemberDAO;

public class MemberValidation implements Validator{
	//Spring���� �����ϴ� Validation
	@Inject
	private MemberDAO dao;
	
	@Override
	public boolean supports(Class<?> arg0) {
		//Ÿ���� �������� �˻縦 �ؼ� true/false�� �����Ѵ�
		return MemberVO.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		MemberVO member = (MemberVO) arg0;
		if(member.getUserid() == null || member.getUserid().trim().isEmpty()){
			arg1.rejectValue("userid", "required");
			//Errors arg1�� ������ �߻������� ������ ����
			//rejectValue�� ���������� Ű���� �˻�, rejecct�� ��ü������ ���ױ׷���
			//userid�� �� �߸��߾�? required�ε� �Է��� ���߾�. �ݵ�� ���� �� �ֵ��� �����ϴ°� 
			//���� �߸��Ǿ����� ǥ�������� 
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
