package kr.or.iei.run;
import kr.or.iei.model.vo.User;
public class Exam {
	public void exam1() {
		User user1 = new User("user01", "pass01", "유저1", 23, 01011112222);
		User user2 = new User("user02", "pass02", "유저2", 27, 01022223333);
		User user3 = new User("user03", "pass03", "유저3", 34, 01033334444);
		
		User[] users = new User[3];
		
		for(int i = 0; i < users.length; i ++) {
			users[i] = user1;
		}
		System.out.println("아이디\t비밀번호\t이름\t나이\t전화번호");
		
		for(int i = 0; i < users.length; i ++) {
			System.out.println(users[i].setId()+"\t"+users[i].setPwd()+"\t"+users[i].setName()+"\t"+users[i].setage+"\t"+users[i].setPhone());
		}
	}
}
