package Main;


import java.awt.Menu;
import java.util.Scanner;

import controller.DepartmentMenu;
import controller.LessonMenu;
import controller.StudentMenu;
import controller.TraineeRegisterSubjectmenu;
import model.Department;
import model.Lesson;
import model.Student;
import model.Trainee;
import view.MenuList;

public class MainTest 
{
	public static Scanner sc =new Scanner(System.in);
	public static void main(String[] args) throws Exception 
	{
		startProject();
		
	}
	public static void startProject() throws Exception 
	{
		StudentMenu stm = new StudentMenu();
		MenuList.showmenu();
		int menu = sc.nextInt();
		switch(menu) 
		{
		case 1://학과 메뉴  
			showDepartmentMenu();
			break;
		case 2: //학생 메뉴
			showStudentMenu();
			break;
		case 3:	//과목 메뉴
			showLessonMenu();
			break;
		case 4:	//수강신청 메뉴
			showTraineeMenu();
			break;
		case 5:	 
			System.out.println("종료");
			return;
		}
		
	}
	public static void showStudentMenu() throws Exception 
	{
		boolean flag=false;
		StudentMenu stm = new StudentMenu();
		
		while(!flag) 
		{
			MenuList.showStudentMenuList();	
			int menu =sc.nextInt();
			switch(menu) 
			{
			case 1: //학생 목록 보기
				stm.showStudentList();
				break;
			case 2: //학생 추가하기 
				Student student =stm.inputStudent();
				stm.insertStudent(student);
				break;
			case 3://학생 정보 수정하기
				stm.updateStudent();
				break;
			case 4://학생 정보 삭제하기
				stm.deleteStudent();
				break;
			case 5://상위 스위치케이스문으로 돌아가기
				startProject();
				flag=true;
				break;
			}
		 }
	}

	
	public static void showTraineeMenu() throws Exception 
	{
		boolean flag=false;
		
		TraineeRegisterSubjectmenu.login();
		while(!flag) 
		{
			System.out.println("1.수강신청목록 2.수강신청 3.수강내역삭제 4.메인메뉴");
			int menu = sc.nextInt();
			switch(menu) 
			{
			case 1 ://수강신청 목록 보기
				TraineeRegisterSubjectmenu.showRegisterSubject();
				break;
			case 2 ://수강신청하기
				Trainee trainee =  TraineeRegisterSubjectmenu.inputRegisterSubject();
				TraineeRegisterSubjectmenu.insertRegisterSubject(trainee);
				break;
			case 3://수강신청 삭제하기 
				TraineeRegisterSubjectmenu.deleteRegisterSubject();
				break;
			case 4 ://상위 스위치 케이스문으로 돌아가기
				startProject();
				flag=true;
				break;
			}
		}
	}
		
	public static void showDepartmentMenu() throws Exception 
	{
		boolean flag=false;
		
		while(!flag) 
		{
		DepartmentMenu dm= new DepartmentMenu();
		MenuList.showDepartmentMenuList();
		int menu =sc.nextInt();
			switch(menu) 
			{
			case 1://학과 정보 목록 
				dm.showStudyList();
				break;
			case 2://학과 정보 입력
				Department department =dm.inputDepartment();
			dm.insertDepartment(department);
				break;
			case 3://학과 정보 수정
				dm.updateDepartment();
				break;
			case 4://학과 정보 삭제
				dm.deleteDepartment();
				break;
			case 5://메인 메뉴
				startProject();
				flag=true;
				break;
			}
		 }

	}
	
	public static void showLessonMenu() throws Exception 
	{
		boolean flag=false;
		while(!flag) 
		{
			MenuList.showLessonMenuList();
			int menu =sc.nextInt();

			
			switch(menu) 
			{
			case 1: //과목 정보 목록
				LessonMenu.showLessonList();
				break;
			case 2: //과목 정보 입력
				Lesson lesson = LessonMenu.inputLesson();
				LessonMenu.insertLesson(lesson);
				break;
			case 3://과목 정보 수정
				LessonMenu.updateLesson();
				break;
			case 4://과목 정보 삭제
				LessonMenu.deleteLesson();
				break;
			case 5://메인 메뉴
				startProject();
				flag=true;
				break;
			}
		 }

	}
	



	

	
}
