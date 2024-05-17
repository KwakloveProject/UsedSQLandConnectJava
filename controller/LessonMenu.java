package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import model.Lesson;

public class LessonMenu 
{
	public static Scanner sc = new Scanner(System.in);
	//과목 관련 함수들	
public static void updateLesson() 
	{
		showLessonList();
		Lesson lesson =searchLesson();
		if(lesson == null)
		{
			System.out.println("일련번호를 찾지못함");
			return;
		}		
		else
		{

			System.out.print("update 과목번호("+lesson.getL_num()+")>>");
			String l_num = sc.nextLine();
			
			System.out.print("update 과목명("+lesson.getL_name()+")>>");
			String l_name = sc.nextLine();
			
			Connection con =null;
			PreparedStatement pstmt = null;
			try 
			{
				con =SQLConnect.makeConnection();
				String sql ="update lesson set l_num=?,l_name=? where no=?";
				pstmt =con.prepareStatement(sql);
				pstmt.setString(1, l_num);
				pstmt.setString(2, l_name);
				pstmt.setInt(3, lesson.getNo());
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

	public static Lesson searchLesson() {
		System.out.println("바꾸실 과목 일련번호를 입력하시오>>");
		int no =sc.nextInt();
		sc.nextLine();
		
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		Lesson lesson =null;
		try 
		{
			con =SQLConnect.makeConnection();
			String sql = "SELECT * from lesson where no = ?";
			pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();

			if(rs.next()) 
			{
				int _no=rs.getInt("no");
				String l_num=rs.getString("l_num");
				String l_name=rs.getString("l_name");
				 lesson =new Lesson(_no, l_num, l_name);
				System.out.println(lesson.toString());
			}
			else 
			{
				System.out.println(no+"일련번호가 없습니다");
				lesson =null;
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
	return lesson;
	}
	

	public static void insertLesson(Lesson lesson) 
	{
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try 
		{
			con =SQLConnect.makeConnection();
			String sql = "INSERT INTO Lesson (no, l_num,l_name) VALUES (subject_seq.NEXTVAL,?,?)";
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, lesson.getL_num());
			pstmt.setString(2, lesson.getL_name());
			int i =pstmt.executeUpdate();
			
			if(i == 1) 
			{
				System.out.println(lesson.getL_num()+"과목 등록성공!!!	");
			}
			else 
			{
				System.out.println(lesson.getL_name()+"과목 등록실패!!!");
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
	
	public static Lesson inputLesson() 
	{
		
		sc.nextLine();
		showLessonList();
		
		System.out.println("과목번호 기입>>");
		String l_num= sc.nextLine();
		
		System.out.println("과목명 기입>>");
		String l_name = sc.nextLine();

		Lesson lesson = new Lesson(0,l_num,l_name);
		return lesson;
	}

	public static void showLessonList() 
	{
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try 
		{
			con =SQLConnect.makeConnection();
			String sql = "SELECT * from lesson" ;
			pstmt =con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) 
			{
				
				int no= rs.getInt("no");
				String l_num = rs.getString("l_num");
				String l_name = rs.getString("l_name");
				Lesson lesson =new Lesson(no, l_num, l_name);
				System.out.println(lesson.toString());
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
	public static void deleteLesson() 
	{
		showLessonList();
		System.out.println("삭제하실 일련번호 입력>>");
		int no = sc.nextInt();	
		
		Connection con =null;
		PreparedStatement pstmt = null;
		try 
		{
			con =SQLConnect.makeConnection();
			String sql = "delete from Lesson where no=?";
			pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, no);
			int i =pstmt.executeUpdate();
			
			if(i == 1) 
			{
				System.out.println(no+"번 정보를 삭제했습니다.");
			}
			else 
			{
				System.out.println(no+"번 정보를 삭제 실패하셨습니다.");
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


}
