package model;

public class Lesson 
{
	private int no;
	private String l_num;
	private String l_name;
	public Lesson(int no, String l_num, String l_name) {
		super();
		this.no = no;
		this.l_num = l_num;
		this.l_name = l_name;
	}
	public Lesson() 
	{
		super();
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getL_num() {
		return l_num;
	}
	public void setL_num(String l_num) {
		this.l_num = l_num;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	@Override
	public String toString() {
		return "과목 일련번호=" + no + ", 과목번호=" + l_num + ", 과목명=" + l_name ;
	}
	
	
	
	
}
