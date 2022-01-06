package co.dev.prj.notice.service;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int id; //�۹�ȣ
	private String writerId; //�ۼ��� ���̵�
	private String writeName; //�ۼ��� �̸�
	private Date writeDate; //�ۼ�����
	private String title; //����
	private String subject; //����
	private int hit;  //��ȸ��
	private String attache; //÷�����ϸ�.
}
