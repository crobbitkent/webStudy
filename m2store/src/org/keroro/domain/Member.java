package org.keroro.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private String mid;
	private String name;
	private String pw;
	private Date regdate;
	private Date updatedate;
	
	public boolean matchPassword(String pw) {
		return pw.equals(pw);
	}
}
