package co.dev.prj.member.serviceImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.dev.prj.member.service.MemberMapper;
import co.dev.prj.member.service.MemberService;
import co.dev.prj.member.service.MemberVO;

@Repository("memberDAO") // @Service, @Component와 동일. 아무거나 써도 됨.
public class MemberServiceImpl implements MemberService {

	@Autowired //
	private MemberMapper map;			//IoC에 있는 SqlSessionTemplate을 자동 주입하라.
	
	@Override
	public List<MemberVO> memberSelectList() {
		// TODO Auto-generated method stub
		return map.memberSelectList();
	}

	@Override
	public MemberVO memberSelect(MemberVO member) {
		// TODO Auto-generated method stub
		return map.memberSelect(member);
	}

	@Override
	public int memberInsert(MemberVO member) {
		// TODO Auto-generated method stub
		return map.memberInsert(member);
	}

	@Override
	public int memberUpdate(MemberVO member) {
		// TODO Auto-generated method stub
		return map.memberUpdate(member);
	}

	@Override
	public int memberDelete(MemberVO member) {
		// TODO Auto-generated method stub
		return map.memberDelete(member);
	}

	@Override
	public boolean isIdCheck(String id) {
		// TODO Auto-generated method stub
		return map.isIdCheck(id);
	}

	@Override
	public List<MemberVO> memberSearch(String key, String data) {
		// TODO Auto-generated method stub
		return map.memberSearch(key, data);
	}
	
	

}
