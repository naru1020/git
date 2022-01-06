package co.dev.prj.notice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.dev.prj.notice.service.NoticeMapper;
import co.dev.prj.notice.service.NoticeService;
import co.dev.prj.notice.service.NoticeVO;

@Repository("noticeDAO")
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeMapper map;

	public int noticeInsert(NoticeVO notice) {
		return map.noticeInsert(notice);
	}

	@Override
	public List<NoticeVO> noticeSelectList() {
		// TODO Auto-generated method stub
		return map.noticeSelectList();
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO notice) {
		// TODO Auto-generated method stub
		return map.noticeSelect(notice);
	}

	@Override
	public int noticeUpdate(NoticeVO notice) {
		// TODO Auto-generated method stub
		return map.noticeUpdate(notice);
	}

	@Override
	public int noticeDelete(NoticeVO notice) {
		// TODO Auto-generated method stub
		return map.noticeDelete(notice);
	}

	@Override
	public int noticeHitUpdate(int id) {
		// TODO Auto-generated method stub
		return map.noticeHitUpdate(id);
	}

	@Override
	public int noticeIdUpdate(int id) {
		// TODO Auto-generated method stub
		return map.noticeIdUpdate(id);
	}

	@Override
	public List<NoticeVO> noticeSearch(String key, String val) {
		// TODO Auto-generated method stub
		return map.noticeSearch(key, val);
	}

}
