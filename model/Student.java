package model;

public class Student 
{
	private int no;
	private String sd_num;
	private String sd_name;
	private String sd_id;
	private String sd_password;
	private String sd_birthday;
	private String sd_phone;
	private String sd_address;
	private String sd_email;
	private String sd_date;
	private String d_num;
	
	public Student() {
		super();
	}

	public Student(String sd_num) 
	{
		super();
		this.sd_num = sd_num;
	}

	public Student(int no, String sd_num, String sd_name,String sd_id, String sd_password, String sd_birthday,
			String sd_phone, String sd_address, String sd_email, String sd_date,String d_num) {
		super();
		this.no = no;
		this.sd_num = sd_num;
		this.sd_name = sd_name;
		this.sd_id = sd_id;
		this.sd_password = sd_password;
		this.sd_birthday = sd_birthday;
		this.sd_phone = sd_phone;
		this.sd_address = sd_address;
		this.sd_email = sd_email;
		this.sd_date = sd_date;
		this.d_num = d_num;
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

	public String getSd_name() {
		return sd_name;
	}

	public void setSd_name(String sd_name) {
		this.sd_name = sd_name;
	}

	public String getSd_id() {
		return sd_id;
	}

	public void setSd_id(String sd_id) {
		this.sd_id = sd_id;
	}

	public String getSd_password() {
		return sd_password;
	}

	public void setSd_password(String sd_password) {
		this.sd_password = sd_password;
	}

	public String getSd_birthday() {
		return sd_birthday;
	}

	public void setSd_birthday(String sd_birthday) {
		this.sd_birthday = sd_birthday;
	}

	public String getSd_phone() {
		return sd_phone;
	}

	public void setSd_phone(String sd_phone) {
		this.sd_phone = sd_phone;
	}

	public String getSd_address() {
		return sd_address;
	}

	public void setSd_address(String sd_address) {
		this.sd_address = sd_address;
	}

	public String getSd_email() {
		return sd_email;
	}

	public void setSd_email(String sd_email) {
		this.sd_email = sd_email;
	}

	public String getSd_date() {
		return sd_date;
	}

	public void setSd_date(String sd_date) {
		this.sd_date = sd_date;
	}

	public String getD_num() {
		return d_num;
	}

	public void setD_num(String s_num) {
		this.d_num = d_num;
	}

	@Override
	public String toString() {
		return "학생일련번호=" + no + ", 학생번호=" + sd_num + ", 성명=" + sd_name + ", 아이디=" + sd_id
				+ ", 비밀번호=" + sd_password + ", 학과번호=" + d_num + ", 생년월일=" + sd_birthday + ", 전화번호="
				+ sd_phone + ", 주소=" + sd_address + ", 이메일=" + sd_email + ", 가입날짜=" + sd_date ;
	}

	
}
