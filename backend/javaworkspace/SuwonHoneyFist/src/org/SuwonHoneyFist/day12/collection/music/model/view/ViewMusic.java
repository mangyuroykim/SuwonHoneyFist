package org.SuwonHoneyFist.day12.collection.music.model.view;

import java.util.List;
import java.util.Scanner;
import org.SuwonHoneyFist.day12.collection.music.model.Music;

public class ViewMusic {
    private Scanner sc;

    public ViewMusic() {
        sc = new Scanner(System.in);  // Scanner 필드를 제대로 초기화
    }

    public int printMenu() {
        System.out.println("=== === 메인 메뉴 === ===");
        System.out.println("1. 마지막 위치에 곡 추가");
        System.out.println("2. 첫 위치에 곡 추가");
        System.out.println("3. 전체 곡 목록 출력");
        System.out.println("4. 특정 곡 검색");
        System.out.println("5. 특정 곡 삭제");
        System.out.println("6. 특정 곡 정보수정");
        System.out.println("7. 곡명 오름차순 정렬");
        System.out.println("8. 곡명 내림차순 정렬");
        System.out.println("9. 가수명 오름차순 정렬");
        System.out.println("10. 가수명 내림차순 정렬");
        System.out.println("0. 종료");
        System.out.print("메뉴 선택 >> ");
        int choice = sc.nextInt();
        return choice;
        
    }

    public void printMsg(String msg) {
        System.out.println(msg);
    }

    public Music inputMusic() {
        sc.nextLine();  // 버퍼 비우기
        System.out.print("곡명: ");
        String title = sc.nextLine();
        System.out.print("가수명: ");
        String singer = sc.nextLine();
        return new Music(title, singer);  // 수정된 부분
    }

    public void printMusicInfo(List<Music> mList) {
        System.out.println("=== === 음악 정보 출력 === ===");
        for (Music music : mList) {
            System.out.printf("\t곡 : %s\n", music.getTitle());
            System.out.printf("\t가수 : %s\n", music.getSinger());
            System.out.println("============================");
            
            
        }
    }

	public String inputTitle(String string) {
		System.out.print(catagory + "할 곡명 : ");
		String title = sc.nextLine();
		return null;
	}

	public void printMusicInfo(Music music) {
		// TODO Auto-generated method stub
		
	}
}
           
