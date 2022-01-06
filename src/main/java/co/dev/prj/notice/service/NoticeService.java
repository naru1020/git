package co.dev.prj.notice.service;

import java.util.List;

public interface NoticeService {
	List<NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO notice);
	int noticeInsert(NoticeVO notice);
	int noticeUpdate(NoticeVO notice);
	int noticeDelete(NoticeVO notice);
	int noticeHitUpdate(int id);  //조회수 증가
	int noticeIdUpdate(int id);   //삭제시 id 비어있지 않게 순번 변경
	
	List<NoticeVO> noticeSearch(String key, String val);
}
