package org.kent.domain;

// JAVA BEAN 공부...
// 본격적이라면 interface serializable
// 그리고 equals, toHash...(?)

// 게시판 클래스
public class Board {
	private String title; // 제목
	private String contents; // 내용
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	//-----------------------ToString-------------------------//
	@Override
	public String toString() {
		return "Board [title=" + title + ", contents=" + contents + "]";
	}
	
	
}
