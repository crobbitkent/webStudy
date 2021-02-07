package org.keroro.question.domain;

import java.sql.Date;

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
	private String aid, quiz, answer, deprecated;
	private int difficulty;
	private Date regdate, updatedate;
}
