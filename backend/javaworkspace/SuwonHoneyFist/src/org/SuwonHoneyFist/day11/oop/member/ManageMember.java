package org.SuwonHoneyFist.day11.oop.member;

import java.util.ArrayList;
import java.util.List;

public class ManageMember {
    private List<Member> members;
    //필드 초기화를 생성자에서
    public ManageMember() {
        members = new ArrayList<>();
    }

    public void insertMember(Member member) {
        members.add(member);
    }

    public Member searchOneByEmail(String email) {
        for (Member member : members) {
            if (member.getMemberEmail().equals(email)) {
                return member;
            }
        }
        return null;
    }

    public Member[] getAllMembers() {
        return members.toArray(new Member[0]);
    }

    public void updateMember(Member updatedMember) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getMemberEmail().equals(updatedMember.getMemberEmail())) {
                members.set(i, updatedMember);
                return;
            }
        }
    }
}
