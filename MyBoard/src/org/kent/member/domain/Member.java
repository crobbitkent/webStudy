package org.kent.member.domain;

import java.sql.Date;

import org.kent.board.domain.Board;

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
	private String mpw;
	private String mname;
	private Date regdate, updatedate;
}
