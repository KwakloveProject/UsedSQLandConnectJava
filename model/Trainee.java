package model;

public class Trainee 
{
	private int no;
	private String sd_num;
	private String l_num;
	private String t_section;
	private String t_date;
	private String l_name;
	public Trainee() 
	{
		super();
	}
	public Trainee(int no, String sd_num, String l_num,String l_name, String t_section, String t_date) {
		super();
		this.no = no;
		this.sd_num = sd_num;
		this.l_num = l_num;
		this.l_name=l_name;
		this.t_section = t_section;
		this.t_date = t_date;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSd_num() {
		return sd_num;
	}
	public void setSd_num(String sd_num) {
		this.sd_num = sd_num;
	}
	public String getL_num() {
		return l_num;
	}
	public void setL_num(String l_num) {
		this.l_num = l_num;
	}
	public void setL_name(String l_name) 
	{
		this.l_name=l_name;
	}
	public String getL_name() 
	{
		return l_name;
	}
	public String getT_section() {
		return t_section;
	}
	public void setT_section(String t_section) {
		this.t_section = t_section;
	}
	public String getT_date() {
		return t_date;
	}
	public void setT_date(String t_date) {
		this.t_date = t_date;
	}
	@Override
	public String toString() {
		return "일련번호=" + no + ", 학생번호=" + sd_num + ", 과목번호=" + l_num +"과목명"+ l_name + ", 과목구분=" + t_section
				+ ", t_date=" + t_date ;
	}

	

}
