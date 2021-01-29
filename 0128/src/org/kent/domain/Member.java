package org.kent.domain;

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
	private String mname;
	private String mpw;
	private Date regdate;
	private Date updatedate;
	
	public boolean matchPassword(String pw) {
		return pw.equals(pw);
	}
}
