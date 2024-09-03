package org.SuwonHoneyFist.day12.collection.student;

public interface ManageInterface {
	void registerStudent(Student student);
	
	private List<Student> sList;
	public ManageStudent() {
		sList = new ArrayList<Student>();
	}
	
	@Override
	public void registerStudent(Student student) {
		sList.add(student);
	}
	@Override
	public java.util.List<Student> searchOneByName(String name) {
		return null;
	}
	
	@Override
	public List<Student> selectAll
	List<Student> searchOneByName(String name);
	
	List <Student> selectAllStudents();
	
	void modifyStudent(int index, Student student);
	
	void deleteStudent(int index);
}
