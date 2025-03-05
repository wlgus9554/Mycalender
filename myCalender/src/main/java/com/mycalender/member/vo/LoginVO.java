package com.mycalender.member.vo;

import lombok.Data;

@Data
public class LoginVO {

	private String email; // 아이디
	private String password; // 비밀번호
	private String name; // 이름
	private String photo; // 사진
	private Integer gradeNo; // 등급번호
	private String gradeName; //grade // 등급명
	private String nickName; // 닉네임
}
