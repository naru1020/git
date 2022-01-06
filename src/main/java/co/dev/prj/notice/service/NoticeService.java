package co.dev.prj.notice.service;

import java.util.List;

public interface NoticeService {
	List<NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO notice);
	int noticeInsert(NoticeVO notice);
	int noticeUpdate(NoticeVO notice);
	int noticeDelete(NoticeVO notice);
	int noticeHitUpdate(int id);  //��ȸ�� ����
	int noticeIdUpdate(int id);   //������ id ������� �ʰ� ���� ����
	
	List<NoticeVO> noticeSearch(String key, String val);
}
