package org.keroro.dto;

import java.sql.Date;

import org.keroro.domain.Review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
	private Long rno; // sno
    private String storeName; // sno
    private String mid;
    private Date reviewdate; // sql의 date
    private Date updatedate;
    private Long score;
    private String text;
}
