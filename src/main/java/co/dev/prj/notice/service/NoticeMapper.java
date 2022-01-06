package co.dev.prj.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList();

	NoticeVO noticeSelect(NoticeVO notice);

	int noticeInsert(NoticeVO notice);

	int noticeUpdate(NoticeVO notice);

	int noticeDelete(NoticeVO notice);

	int noticeHitUpdate(int id); // 조회수 증가

	int noticeIdUpdate(int id); // 삭제시 id 비어있지 않게 순번 변경

	// mapper 인터페이스에는 @param을 써야 파라미터로 인식한다.
	List<NoticeVO> noticeSearch(@Param("key") String key, @Param("val") String val);
}
