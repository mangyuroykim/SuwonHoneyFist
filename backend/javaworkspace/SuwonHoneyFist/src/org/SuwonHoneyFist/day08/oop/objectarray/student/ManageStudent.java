package org.SuwonHoneyFist.day08.oop.objectarray.student;

import java.util.ArrayList;
import java.util.List;

public class ManageStudent {
    private List<Student> students;

    public ManageStudent() {
        students = new ArrayList<>();
    }

    public void addStudent(String name, int firstScore, int secondScore) {
        students.add(new Student(name, firstScore, secondScore));
    }

    public void printAllStudents() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println("======" + (i + 1) + "번째 학생의 정보 출력 ======");
            System.out.println(students.get(i).toString());
        }
    }
}
