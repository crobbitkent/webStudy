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
public class Review {
	private Long rno; // sno
    private Long sno; // sno
    private String mid;
    private Date regdate; // sql의 date
    private Date updatedate;
    private Long score;
    private String text;
}
