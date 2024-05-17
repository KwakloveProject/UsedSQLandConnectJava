package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import model.Student;

public class StudentMenu 
{
	public static Scanner sc = new Scanner(System.in);
	//학생 관련 함수들
	public void deleteStudent() 
	{
		showStudentList();
		System.out.println("삭제하실 일련번호 입력>>");
		int no = sc.nextInt();	
		
		Connection con =null;
		PreparedStatement pstmt = null;
		try 
		{
			con =SQLConnect.makeConnection();
			String sql = "delete from student where no=?";
			pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, no);
			int i =pstmt.executeUpdate();
			
			if(i == 1) 
			{
				System.out.println(no+"번 학생을 삭제했습니다.");
			}
			else 
			{
				System.out.println(no+"번 학생을 삭제 실패하셨습니다.");
			}
		
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}  catch (Exception e) {
			e.printStackTrace();
		}
		finally 
		{
				try 
				{
					 if(pstmt!=null) 
					{
					pstmt.close();
					}
					 if(con!=null) 
					{
					con.close();
					}
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
		}
	}


	public  Student searchStudent() 
	{
		System.out.println("바꾸실 학생 일련번호를 입력하시오>>");
		int no =sc.nextInt();
		sc.nextLine();
		
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		Student student =null;
		try 
		{
			con =SQLConnect.makeConnection();
			String sql = "SELECT * from student where no = ?";
			pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();

			if(rs.next()) 
			{
				int _no=rs.getInt("no");
				String sd_num=rs.getString("sd_num");
				String sd_name=rs.getString("sd_name");
				String sd_id=rs.getString("sd_id");
				String sd_password=rs.getString("sd_password");
				String sd_birthday=rs.getString("sd_birthday");
				String sd_phone=rs.getString("sd_phone");
				String sd_address=rs.getString("sd_address");
				String sd_email= rs.getString("sd_email");
				String sd_date=rs.getString("sd_date");
				String d_num=rs.getString("d_num");
				 student =new Student(_no, sd_num, sd_name, sd_id, sd_password, sd_birthday, sd_phone, sd_address, sd_email, sd_date, d_num);
				System.out.println(student.toString());
			}
			else 
			{
				System.out.println(no+"일련번호가 없습니다");
				student =null;
			}
			
		}
		
		 catch (Exception e) {
			e.printStackTrace();
		}
		finally 
		{
				try 
				{
					if(rs!=null) 
					{
					rs.close();
					}
					 if(pstmt!=null) 
					{
					pstmt.close();
					}
					 if(con!=null) 
					{
					con.close();
					}
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
		
		}
	return student;
	}
	public void updateStudent() {
		showStudentList();
		Student student =searchStudent();
		if(student == null)
		{
			System.out.println("일련번호를 찾지못함");
			return;
		}		
		else
		{
			System.out.print("update sd_num("+student.getSd_num()+")>>");
			String sd_num = sc.nextLine();
			
			System.out.print("update sd_name("+student.getSd_name()+")>>");
			String sd_name = sc.nextLine();
			
			System.out.print("update sd_id("+student.getSd_id()+")>>");
			String sd_id = sc.nextLine();
			
//			sd_num,sd_name,sd_id,sd_password,s_num,sd_birthday,sd_phone,sd_address,sd_email
			System.out.print("update sd_password("+student.getSd_password()+")>>");
			String sd_password = sc.nextLine();
			
			System.out.print("update sd_birthday("+student.getSd_birthday()+")>>");
			String sd_birthday = sc.nextLine();
			
			System.out.print("update sd_phone("+student.getSd_phone()+")>>");
			String sd_phone = sc.nextLine();
			
			System.out.print("update sd_address("+student.getSd_address()+")>>");
			String sd_address = sc.nextLine();
			
			System.out.print("update sd_email("+student.getSd_email()+")>>");
			String sd_email = sc.nextLine();
			
			System.out.print("update 학과번호("+student.getD_num()+")>>");
			String d_num = sc.nextLine();
			
			Connection con =null;
			PreparedStatement pstmt = null;
			try 
			{
				con =SQLConnect.makeConnection();
				String sql ="update student set sd_num=?,sd_name=?, sd_id=?,sd_password=?,sd_birthday=?,sd_phone=?,sd_address=?,sd_email=?,sd_date=sysdate ,d_num=? where no=?";
				pstmt =con.prepareStatement(sql);
				pstmt.setString(1, sd_num);
				pstmt.setString(2, sd_name);
				pstmt.setString(3, sd_id);
				pstmt.setString(4, sd_password);
				pstmt.setString(5, sd_birthday);
				pstmt.setString(6, sd_phone);
				pstmt.setString(7, sd_address);
				pstmt.setString(8, sd_email);
				pstmt.setString(9, d_num);
				pstmt.setInt(10, student.getNo());
				int i =pstmt.executeUpdate();
				if(i == 1) 
				{
					System.out.println("수정됐습니다.");
				}
				else 
				{
					System.out.println("수정실패하셨습니다.");
				}
				
			}
			catch(SQLException e) 
			{
				System.out.println("학과번호 제대로 기입하세요!!");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally 
			{
				try 
				{
					if(pstmt!=null) 
					{
						pstmt.close();
					}
					if(con!=null) 
					{
						con.close();
					}
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			
		}
	}


	public void insertStudent(Student student) 
	{
		DepartmentMenu dm = new DepartmentMenu();
		dm.showStudyList();
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try 
		{
			con =SQLConnect.makeConnection();
			String sql = "INSERT INTO student (no,sd_num,sd_name,sd_id,sd_password,sd_birthday,sd_phone,sd_address,sd_email,sd_date,d_num) VALUES (student_seq.NEXTVAL,?,?,?,?,?,?,?,?,sysdate,?)";
			pstmt =con.prepareStatement(sql);
	
			pstmt.setString(1, student.getSd_num());
			pstmt.setString(2, student.getSd_name());
			pstmt.setString(3, student.getSd_id());
			pstmt.setString(4, student.getSd_password());
			pstmt.setString(5, student.getSd_birthday());
			pstmt.setString(6, student.getSd_phone());
			pstmt.setString(7, student.getSd_address());
			pstmt.setString(8, student.getSd_email());
			pstmt.setString(9, student.getD_num());
			int i =pstmt.executeUpdate();
			
			if(i == 1) 
			{
				System.out.println(student.getSd_name()+"학생 등록성공!!!	");
			}
			else 
			{
				System.out.println(student.getSd_name()+"학생 등록실패!!!");
			}
		
		}
		catch(SQLException e) 
		{
			System.out.println("학과번호 제대로 기입하시오!!\n");

		}  catch (Exception e) {
			
			e.printStackTrace();
		}
		finally 
		{
				try 
				{
					if(rs!=null) 
					{
					rs.close();
					}
					 if(pstmt!=null) 
					{
					pstmt.close();
					}
					 if(con!=null) 
					{
					con.close();
					}
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
		
		}
		
	}
	public Student inputStudent() {
		
		DepartmentMenu sm = new DepartmentMenu();
		sm.showStudyList();
//		sd_num,sd_name,sd_id,sd_password,s_num,sd_birthday,sd_phone,sd_address,sd_email
		System.out.println("학생번호 기입>>");
		String sd_num = sc.nextLine();
		
		System.out.println("학생이름 기입>>");
		String sd_name = sc.nextLine();
		
		System.out.println("학생ID 기입>>");
		String sd_id = sc.nextLine();
		
		System.out.println("학생PW 기입>>");
		String sd_password = sc.nextLine();
		
		
		System.out.println("학생생일 기입>>");
		String sd_birthday = sc.nextLine();
		
		System.out.println("학생전화번호 기입>>");
		String sd_phone = sc.nextLine();
		
		System.out.println("학생주소 기입>>");
		String sd_address = sc.nextLine();
		
		System.out.println("학생이메일 기입>>");
		String sd_email = sc.nextLine();
		
		System.out.println("학과번호 기입>>");
		String d_num = sc.nextLine();

		Student student = new Student(0,sd_num, sd_name, sd_id, sd_password, sd_birthday, sd_phone, sd_address, sd_email, null,d_num);
		return student;
	}
	public  void showStudentList() 
	{
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try 
		{
			con =SQLConnect.makeConnection();
			String sql = "SELECT * from student" ;
			pstmt =con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) 
			{
				//sd_num,sd_name,sd_id,sd_password,sd_birthday,sd_phone,sd_address,sd_email,sd_date,s_num
				int no= rs.getInt("no");
				String sd_num = rs.getString("sd_num");
				String sd_name = rs.getString("sd_name");
				String sd_id = rs.getString("sd_id");
				String sd_password = rs.getString("sd_password");
				String sd_birthday = rs.getString("sd_birthday");
				String sd_phone = rs.getString("sd_phone");
				String sd_address = rs.getString("sd_address");
				String sd_email = rs.getString("sd_email");
				String sd_date = rs.getString("sd_date");
				String d_num = rs.getString("d_num");
				
				Student student = new Student(no,sd_num, sd_name, sd_id, sd_password, sd_birthday, sd_phone, sd_address, sd_email, sd_date,d_num);
			
				System.out.println(student.toString());
			}
		}
		
	  catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		finally 
		{
				try 
				{
					if(rs!=null) 
					{
						rs.close();
					}
					else if(pstmt!=null) 
					{
						pstmt.close();
					}
					else if(con!=null) 
					{
						con.close();
					}
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
		
		}
		
	}
}
