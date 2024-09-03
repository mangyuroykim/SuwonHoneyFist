package org.SuwonHoneyFist.day12.collection.list;

public class Member {
    // Member 클래스의 필드와 메서드를 여기에 정의할 수 있습니다.
}

public class MemberList {
    Member[] members;
    int size;

    public MemberList() {
        members = new Member[3];
        size = 0;
    }

    // 추가
    public void add(Member member) {
        if (size == members.length) {
            // 배열 크기를 늘림
            Member[] newMembers = new Member[members.length * 2];
            for (int i = 0; i < members.length; i++) {
                newMembers[i] = members[i];
            }
            members = newMembers;
        }
        members[size] = member;
        size++;
    }

    // 조회
    public Member get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return members[index];
    }

    // 크기
    public int size() {
        return size;
    }

    // 전체삭제
    public void clear() {
        members = new Member[3];
        size = 0;
    }
}
