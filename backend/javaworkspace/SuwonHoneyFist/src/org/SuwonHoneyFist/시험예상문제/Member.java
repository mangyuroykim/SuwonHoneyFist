package org.SuwonHoneyFist.시험예상문제;
//회원의 정보를 저장하기 위하여 Member 객체를 생성하였다.
//Member객체를 사용하여 데이터를 입력하고 출력하기 위해 소스코드를 작성하였는데 컴파일시
//문제가 발생하였다. Member 객체 및 소스코드를 분석하여 원인(문제점+사유) 및 조치내용(해결방안)을 작성하시오.
public class Member {
	private String name;
	private int age;
	private String address;
	private String hobby;

	public Member() {
	}

	public Member(String name, int age, String address, String hobby) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.hobby = hobby;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public static void main(String[] args) {
		Member m = new Member();
		m.setName("홍길동");
		m.setAge(25);
		m.setAddress("서울시 영등포구");
		m.setHobby("독서");
		System.out.println("이름 : " + m.getName());
		System.out.println("나이 : " + m.getAge());
		System.out.println("주소 : " + m.getAddress());
		System.out.println("취미 : " + m.getHobby());
	}
}
// 아니면  Member m = new Member("홍길동", 25, "서울시 영등포구", "독서"); 이렇게 변경
