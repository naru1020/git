package co.dev.prj.notice.service;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int id; //글번호
	private String writerId; //작성자 아이디
	private String writeName; //작성자 이름
	private Date writeDate; //작성일자
	private String title; //제목
	private String subject; //내용
	private int hit;  //조회수
	private String attache; //첨부파일명.
}
