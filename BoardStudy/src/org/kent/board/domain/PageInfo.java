package org.kent.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo {
	@Default
	private int page = 1; // 페이지 번호
	@Default
	private int perSheet = 20; // 페이지 하나당 들어갈 수 있는 게시판의 개수
	
	public void setPage(int number) {
		if(0 >= number) {
			this.page = 1;
			return;
		}
		
		this.page = number;
	}
	
	public void setPerSheet(int number) {
		if(100 <= number) {
			this.perSheet = 100;
			return;
		}
		
		if (20 > number) {
			this.perSheet = 20;
			return;
		}
		
		this.perSheet = number;
	}
	
}
