package org.SuwonHoneyFist.day10.oop.member;

public class ManageMember {
	private Member[] members = new Member[5];
	private int count = 0;

	public void registerMember(Member member) {
		if (count < members.length) {
			members[count++] = member;
		} else {
			System.out.println("회원 목록이 가득 찼습니다.");
		}
	}

	public Member[] allMember() {
		return members;
	}
	public Member searchOneById(String memberId) {
		for(Member member : members) {
			if(memberId.equals(member.getMemberId())) {
				return member;
			}
		}
	}
}
