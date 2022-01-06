package co.dev.prj.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList();

	NoticeVO noticeSelect(NoticeVO notice);

	int noticeInsert(NoticeVO notice);

	int noticeUpdate(NoticeVO notice);

	int noticeDelete(NoticeVO notice);

	int noticeHitUpdate(int id); // ��ȸ�� ����

	int noticeIdUpdate(int id); // ������ id ������� �ʰ� ���� ����

	// mapper �������̽����� @param�� ��� �Ķ���ͷ� �ν��Ѵ�.
	List<NoticeVO> noticeSearch(@Param("key") String key, @Param("val") String val);
}
