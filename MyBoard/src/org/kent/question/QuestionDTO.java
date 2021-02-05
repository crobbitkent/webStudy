package org.kent.question;

import java.sql.Date;

import org.kent.question.domain.Question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
	private String mid;
	private Long qno;
	private int difficulty;
	private Long random;
}
