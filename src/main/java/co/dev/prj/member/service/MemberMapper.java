package co.dev.prj.member.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
	List<MemberVO> memberSelectList();

	MemberVO memberSelect(MemberVO member); // 단건조회 + 로그인

	int memberInsert(MemberVO member);

	int memberUpdate(MemberVO member);

	int memberDelete(MemberVO member);

	boolean isIdCheck(String id);
	
	List<MemberVO> memberSearch(@Param("key") String key, @Param("data") String data);

}
