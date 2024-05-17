package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import model.Student;
import model.Trainee;

public class TraineeRegisterSubjectmenu 
{
	public static Scanner sc = new Scanner(System.in);
	//수강신청 함수들
	public static void insertRegisterSubject(Trainee trainee) 
	{
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try 
		{
			con =SQLConnect.makeConnection();
			String sql = "INSERT INTO trainee VALUES (trainee_seq.NEXTVAL,?,?,?,sysdate,?)";
			pstmt =con.prepareStatement(sql);
	
			pstmt.setString(1, trainee.getSd_num());
			pstmt.setString(2, trainee.getL_num());
			pstmt.setString(3, trainee.getT_section());
			pstmt.setString(4, trainee.getL_name());
			int i =pstmt.executeUpdate();
			
			if(i == 1) 
			{
				System.out.println(trainee.getL_name()+"수강신청 성공!!!");
			}
			else 
			{
				System.out.println(trainee.getL_name()+"수강신청 실패!!!");
			}
		
		}
		catch(SQLException e) 
		{
			System.out.println("학생ID와 과목명을 제대로 기입했는지 확인하시오!!\n");

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

	public static Trainee inputRegisterSubject() 
	{
				
					boolean flag=false;
					LessonMenu.showLessonList();
					System.out.println("당신의 학생번호 기입>>");
					String sd_num = sc.nextLine();
					
					System.out.println("과목번호 기입>>");
					String l_num = sc.nextLine();
					
					System.out.println("과목이름 기입>>");
					String l_name = sc.nextLine();
					
					System.out.println("과목구분(교양,전공,부전공) 기입>>");
					String t_section = sc.nextLine();
					Trainee trainee = new Trainee(0, sd_num, l_num, l_name, t_section,null);
					return trainee;
	}
	
	public static void showRegisterSubject() 
	{
		boolean flag=false;
		while(!flag) 
		{
			System.out.println("찾으실 수강내역의 학생ID를 입력하시오>>");
			String sd_num =sc.nextLine();
			
			Connection con =null;
			PreparedStatement pstmt = null;
			ResultSet rs =null;
			Trainee trainee =null;
			try 
			{
				con =SQLConnect.makeConnection();
				String sql = "SELECT * from trainee where sd_num = ?";
				pstmt =con.prepareStatement(sql);
				pstmt.setString(1, sd_num);
				rs=pstmt.executeQuery();
				
				if(rs.next()) 
				{
					int _no=rs.getInt("no");
					String _sd_num=rs.getString("sd_num");
					String l_num=rs.getString("l_num");
					String t_section=rs.getString("t_section");
					String t_date=rs.getString("t_date");
					String l_name=rs.getString("l_name");
					trainee =new Trainee(_no, _sd_num, l_num, l_name, t_section, t_date);
					System.out.println(trainee.toString());
					flag=true;
				}
				else 
				{
					System.out.println("존재하지 않는 ID거나 신청하신 기록이 없습니다.");
					flag=true;
					
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
		}
	}
	
	public static void deleteRegisterSubject() throws Exception
	{
				boolean flag=false;
				System.out.println("삭제하실 수강내역의 학생ID를 입력하시오>>");
				String sd_num =sc.nextLine();
				
				Connection con =null;
				PreparedStatement pstmt = null;
				ResultSet rs =null;
				Trainee trainee =null;
				
					con =SQLConnect.makeConnection();
					String sql = "SELECT * from trainee where sd_num = ?";
					pstmt =con.prepareStatement(sql);
					pstmt.setString(1, sd_num);
					rs=pstmt.executeQuery();
					
					sql = "delete from trainee where sd_num = ?";
					pstmt =con.prepareStatement(sql);
					pstmt.setString(1, sd_num);
					int i =pstmt.executeUpdate();
					if(rs.next()) 
					{
						int _no=rs.getInt("no");
						String _sd_num=rs.getString("sd_num");
						String l_num=rs.getString("l_num");
						String t_section=rs.getString("t_section");
						String t_date=rs.getString("t_date");
						String l_name=rs.getString("l_name");
						trainee =new Trainee(_no, _sd_num, l_num, l_name, t_section, t_date);
						System.out.println(trainee.toString());
						//삭제
						if(i == 1) 
						{
							System.out.println(sd_num+"번 정보를 삭제했습니다.");
						}
						else 
						{
							System.out.println(sd_num+"번 정보를 삭제 실패하셨습니다.");
						}
						
						}
					return;
					}	
	
	public static void login() throws Exception 
	{
			boolean flag =false;
			Connection con =null;
			PreparedStatement pstmt = null;
			ResultSet rs =null;
			Student student =null;
			while(!flag) 
			{
				System.out.println("로그인하시오");
				System.out.println("학생ID를 입력하시오>>");
				String sd_num =sc.nextLine();
				
				
				con =SQLConnect.makeConnection();
				String sql ="SELECT * from student where sd_num = ?";
				pstmt =con.prepareStatement(sql);
				pstmt.setString(1, sd_num);
				rs=pstmt.executeQuery();
				if(rs.next()) //값이 있으면 출력//이건 저 *에서 가져오는 만큼 getString getInt 같은거 써서 데이터 불러 오는 거임
				{
					flag =true;
				}
				else 
				{
					System.out.println("아이디가 없습니다");
				}
			}
		
				int _no=rs.getInt("no");
				String _sd_num=rs.getString("sd_num");
				String sd_name=rs.getString("sd_name");
				String sd_id=rs.getString("sd_id");
				String sd_password=rs.getString("sd_password");
				String sd_birthday=rs.getString("sd_birthday");
				String sd_phone=rs.getString("sd_phone");
				String sd_address=rs.getString("sd_address");
				String sd_email= rs.getString("sd_email");
				String sd_date=rs.getString("sd_date");
				String d_num=rs.getString("d_num");
				student =new Student(_no, _sd_num, sd_name, sd_id, sd_password, sd_birthday, sd_phone, sd_address, sd_email, sd_date, d_num);
				System.out.println(student.getSd_name()+"님환영합니다");
	}




}
