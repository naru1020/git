package noticeSelectList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.dev.prj.notice.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeDao;
	
	@RequestMapping("/noticeSelectList.do")
	public String noticeSelectList(Model model) {
		model.addAttribute("notices", noticeDao.noticeSelectList());
		return "notice/noticeSelectList";
	}
}
