package co.dev.prj.member.service;

import java.util.List;

public interface MemberService {
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO member); //�ܰ���ȸ + �α���
	int memberInsert(MemberVO member);
	int memberUpdate(MemberVO member);
	int memberDelete(MemberVO member);
	
	boolean isIdCheck(String id);
	List<MemberVO> memberSearch(String key, String data);
		
}
