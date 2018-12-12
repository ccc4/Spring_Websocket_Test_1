package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Chat_room_members {
	
	private int idx;
	private int m_idx;
	private String grade;
	private Date join_date;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getM_idx() {
		return m_idx;
	}
	public void setM_idx(int m_idx) {
		this.m_idx = m_idx;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/*
	public Date getJoin_date() {
		return join_date;
	}
	*/
	public String getJoin_date() {
		return changeDateType(join_date);
	}
	
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	
	//Date 타입 String으로 변환시키기
	public String changeDateType(Date join_date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss a");
		return sdf.format(join_date);
	}

}
