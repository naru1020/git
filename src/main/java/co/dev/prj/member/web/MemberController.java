package co.dev.prj.member.web;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.dev.prj.member.service.MemberService;
import co.dev.prj.member.service.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberDAO; // dao 자동 주입.

	@Autowired
	private String saveDir; // 파일 저장 경로를 자동 주입

	@RequestMapping("/memberSelectList.do")
	public String memberSelectList(Model model) {
		// 모델 객체 : 결과를 실어서 전달할 페이지에 보낸다.?

		model.addAttribute("members", memberDAO.memberSelectList());
		return "member/memberSelectList";
	}
	
	@RequestMapping("/memberJoin.do") // post 방식 전달, get 방식일 때는 403 오류
	public String memberJoin(@RequestParam("file") MultipartFile file, MemberVO member, Model model) {
		
		//파일 업로드
		String originalFileName = file.getOriginalFilename(); //첨부한 원본파일명
		//String saveDir = "fileUpload" + File.separatorChar; //실제 배포 시 (서버에서) 저장 공간.
		
		if (!originalFileName.isEmpty()) {
			String uuid = UUID.randomUUID().toString(); //물리파일명을 위한 고유 아이디 생성.
			// uuid에 파일확장자 추가하여 물리적 파일명을 만듦.
			String saveFileName = uuid + originalFileName.substring(originalFileName.lastIndexOf("."));
			//마지막 .을 만나는 지점부터 -> 확장자명.
			//IO exception 일어날 수 있으니 try-catch 활용.
			try {
				file.transferTo(new File(saveDir, saveFileName)); //파일저장
				//saveDir -> 저장공간, saveFileName -> 저장할 이름.
				member.setPicture(originalFileName);
				member.setPfile(saveFileName);
				//vo에 담기.
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		int result = memberDAO.memberInsert(member);
		//파일이 저장이 다 되었다면 insert해줌.
		
		if (result == 1) {
			model.addAttribute("message", "회원가입이 성공적으로 완료되었습니다.");
		} else {
			model.addAttribute("message", "오류가 발생했습니다. 관리자에게 문의하세요");
		}

		return "member/memberJoin";
	}

	@RequestMapping("/memberJoinForm.do")
	public String memberJoinForm(MemberVO member, Model model) {
		return "member/memberJoinForm";
	}

	@PostMapping("/ajaxIsIdCheck.do")
	@ResponseBody
	public boolean ajaxIsIdCheck() {
		return false;

	}

	@GetMapping("/memberRead.do") // get방식 전달, post 방식일 경우에는 403 에러.
	public String memberRead(String id, Model model) {
		return "membr/memberRead";
	}

	@RequestMapping("/memberLoginForm.do")
	public String memberLoginForm(String id, String password) {
		return "member/memberLoginForm";
	}

	@PostMapping("/memberLogin.do")
	public String memberLogin(MemberVO member, Model model, HttpSession session) {
		member = memberDAO.memberSelect(member);
		if (member != null) {
			session.setAttribute("id", member.getId()); // 세션에 아이디값 담기.
			session.setAttribute("author", member.getAuthor()); // 세션에 권한 담기.
			model.addAttribute("message", member.getName() + "님 환영합니다.");
		} else {
			model.addAttribute("message", "아이디 또는 패스워드가 틀립니다.");
		}
		return "member/memberLogin";
	}

	@RequestMapping("/memberLogout.do")
	public String memberLogout(HttpSession session, Model model) {
		session.invalidate(); // 세션을 서버에서 삭제.
		model.addAttribute("message", "로그아웃이 정상적으로 처리되었습니다.");
		return "member/memberLogout";
	}

	@PostMapping("/ajaxSearchMember.do")
	@ResponseBody
	public List<MemberVO> ajaxSearchMember(@RequestParam("key") String key, @RequestParam("data") String data) {
		return memberDAO.memberSearch(key, data);
	}

}
