package org.kent.question.domain;

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
public class Question {
	private Long qno;
	private String quiz;
	private String answer;
	private int difficulty;
	private Date regdate, updatedate;
}
