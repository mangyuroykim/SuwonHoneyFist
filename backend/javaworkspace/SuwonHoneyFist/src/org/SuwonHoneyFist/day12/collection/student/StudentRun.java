package org.SuwonHoneyFist.day12.collection.student;

import java.util.List;

import org.SuwonHoneyFist.day08.oop.student.ViewStudent;

public class StudentRun {
	public static void main(String[] args) {
		ManageStudent mng = new ManageStudent();
		ViewStudent view = new ViewStudent();
		끝: while (true) {
			int input = view.printMenu();
			switch (input) {
			case 1:
				Student std = view.inputStudent();
				mng.registerStudent(std);
				break;
			case 2:
				String name = view.inputName("검색");
				List<Student> sList = mng.searchOneByName(name);
				view.displayMsg(sList);
				break;
			case 3:
				List<Student> stdList = mng.selectAllStudents();
				if(stdList.size() > 0)
					view.displayStudents(stdList);
				else
					view.displayMsg("회원정보가 없습니다.");
				break;
			case 4:
				name = view.inputName("수정");
//				Student student = mng.searchModifyStudent(name);
//				student = view.modifyStudent(student);
				int index = mng.serchIndexByName(name);
				Student student = mng.searchModifyStudent(name);
				mng.modifyStudent(index, student);
				break;
			case 5: 
				name = view.inputName("삭제");
				index = mng.searchIndexByName(name);
				mng.deleteStudent(index);
				break;
			case 6:
				name = view.inputName("재평가 여부를 확인");
				student = mng.searchOneByName(name);
				String passResult = checkPass(student);
				view.displyaMsg(passResult);
				break;
			case 0:
				view.displayMsg("프로그램을 종료합니다");
				break 끝;
			default:
				view.displayMsg("메뉴를 다시 선택해 주세요");
			}
		}
	}
	
	private static String checkPass(Student student) {
		// TODO Auto-generated method stub
		int first = student.getFirstScore();
		int second = student.getSecondScore();
		// 평균이 60점이 넘으면 통과
		// 평균이 60점이 안되면 재평가
		double avg = (first+second/(double)2;
		if(avg >= 60) {
			if(first < 40) {
				return "1차 시험 재평가";
			}else if (second < 40 ) {
				return "2차 시험 재평가";
				
			}else {
				String result = "";
				if(first < 60) {
					result +="1차 시험 재평가 \n";
					
				}
				if(second < 60) {
					result += "2차 시험 재평가";
				}
				return result;
			}
		}
	}}	
	

