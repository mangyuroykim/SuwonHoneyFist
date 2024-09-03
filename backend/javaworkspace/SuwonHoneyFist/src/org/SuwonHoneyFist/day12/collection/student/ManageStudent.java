package org.SuwonHoneyFist.day12.collection.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManageStudent implements ManageInterface {

    private List<Student> sList;

    public ManageStudent() {
        sList = new ArrayList<Student>();
    }

    @Override
    public void registerStudent(Student student) {
        sList.add(student);
    }

    @Override
    public List<Student> searchOneByName(String name) {
        List<Student> searchList = new ArrayList<>();
        if (name != null) {
            for (Student std : sList) {
                if (name.equals(std.getName())) {
                    // 찾았다!!
                    searchList.add(std);
                }
            }
        }
        return searchList;
    }

    @Override
    public List<Student> selectAllStudents() {
        return sList;
    }

    @Override
    public void modifyStudent(int index, Student student) {
        if (index >= 0 && index < sList.size()) {
            sList.set(index, student);
        }
    }

    @Override
    public void deleteStudent(int index) {
        if (index >= 0 && index < sList.size()) {
            sList.remove(index);
        }
    }

    public Map<String, Object> searchModifyStudent(String name) {
        if (name != null) {
            Map<String, Object> result = new HashMap<>();
            for (int i = 0; i < sList.size(); i++) {
                Student student = sList.get(i);
                if (name.equals(student.getName())) {
                    result.put("student", student);
                    result.put("index", i);
                    return result;
                }
            }
        }
        return null;
    }

    public int searchIndexByName(String name) {
        if (name != null) {
            for (int i = 0; i < sList.size(); i++) {
                if (name.equals(sList.get(i).getName())) {
                    return i;
                }
            }
        }
        return -1; // 찾지 못하면 -1 반환
    }
}

@Override
public List<Student> searchListByName(String name) {
    List<Student> searchList = new ArrayList<>();
    if (name != null) {
        for (Student std : sList) {
            if (name.equals(std.getName())) {
                // 찾았다!!
                searchList.add(std);
            }
        }
    }
    return searchList;
}

public String checkPass(Student student) {
	// TODO Auto-generated method stub
	int first = student.getFirstScore();
	int second = student.getSecondScore();
	// 평균이 60점이 넘으면 통과
	// 평균이 60점이 안되면 재평가
	double avg = (first+second)/2.0;
	if(avg >= 60) {
		if(first < 40) {
			System.out.println("1차 시험 재평가");
		}else if (second < 40) {
			System.out.println("2차 시험 재평가");
			
		}else {
			System.out.println("모두 통과입니다.");
		}
	}else {
		if(first < 60) {
			System.out.println("1차 시험 재평가");
		}
		if(second < 60) {
			System.out.println("2차 시험 재평가");
		}
	}
		return null;
}

