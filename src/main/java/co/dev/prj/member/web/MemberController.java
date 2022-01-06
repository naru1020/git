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
	private MemberService memberDAO; // dao �ڵ� ����.

	@Autowired
	private String saveDir; // ���� ���� ��θ� �ڵ� ����

	@RequestMapping("/memberSelectList.do")
	public String memberSelectList(Model model) {
		// �� ��ü : ����� �Ǿ ������ �������� ������.?

		model.addAttribute("members", memberDAO.memberSelectList());
		return "member/memberSelectList";
	}
	
	@RequestMapping("/memberJoin.do") // post ��� ����, get ����� ���� 403 ����
	public String memberJoin(@RequestParam("file") MultipartFile file, MemberVO member, Model model) {
		
		//���� ���ε�
		String originalFileName = file.getOriginalFilename(); //÷���� �������ϸ�
		//String saveDir = "fileUpload" + File.separatorChar; //���� ���� �� (��������) ���� ����.
		
		if (!originalFileName.isEmpty()) {
			String uuid = UUID.randomUUID().toString(); //�������ϸ��� ���� ���� ���̵� ����.
			// uuid�� ����Ȯ���� �߰��Ͽ� ������ ���ϸ��� ����.
			String saveFileName = uuid + originalFileName.substring(originalFileName.lastIndexOf("."));
			//������ .�� ������ �������� -> Ȯ���ڸ�.
			//IO exception �Ͼ �� ������ try-catch Ȱ��.
			try {
				file.transferTo(new File(saveDir, saveFileName)); //��������
				//saveDir -> �������, saveFileName -> ������ �̸�.
				member.setPicture(originalFileName);
				member.setPfile(saveFileName);
				//vo�� ���.
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		int result = memberDAO.memberInsert(member);
		//������ ������ �� �Ǿ��ٸ� insert����.
		
		if (result == 1) {
			model.addAttribute("message", "ȸ�������� ���������� �Ϸ�Ǿ����ϴ�.");
		} else {
			model.addAttribute("message", "������ �߻��߽��ϴ�. �����ڿ��� �����ϼ���");
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

	@GetMapping("/memberRead.do") // get��� ����, post ����� ��쿡�� 403 ����.
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
			session.setAttribute("id", member.getId()); // ���ǿ� ���̵� ���.
			session.setAttribute("author", member.getAuthor()); // ���ǿ� ���� ���.
			model.addAttribute("message", member.getName() + "�� ȯ���մϴ�.");
		} else {
			model.addAttribute("message", "���̵� �Ǵ� �н����尡 Ʋ���ϴ�.");
		}
		return "member/memberLogin";
	}

	@RequestMapping("/memberLogout.do")
	public String memberLogout(HttpSession session, Model model) {
		session.invalidate(); // ������ �������� ����.
		model.addAttribute("message", "�α׾ƿ��� ���������� ó���Ǿ����ϴ�.");
		return "member/memberLogout";
	}

	@PostMapping("/ajaxSearchMember.do")
	@ResponseBody
	public List<MemberVO> ajaxSearchMember(@RequestParam("key") String key, @RequestParam("data") String data) {
		return memberDAO.memberSearch(key, data);
	}

}
