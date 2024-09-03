package org.SuwonHoneyFist.day12.collection.music.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ManageMusic {
	private List<Music> mList;

	public ManageMusic() {
		mList = new ArrayList<Music>();
	}

	// 맨뒤에 곡 추가
	public void registerMusic(Music music) {
		mList.add(music);
	}

	// 맨 앞에 곡 추가
	public void registerMusicAtFirst(Music music) {
		// TODO Auto-generated method stub
		mList.add(0, music);

	}

	public List<Music> getAllMusics() {
		return mList;
		// TODO Auto-generated method stub

	}

	public Music serchMusicBytitle(String name) {
		// TODO Auto-generated method stub
		if (name != "" && name != null) {
			for (Music music : mList) {
				if (name.equals(music.getTitle())) {
					return music;
				}
			}
		}
		return null;
	}

	public int searchIndexByName(String name) {
		// TODO Auto-generated method stub
		if (name != "" && name != null) {
			for (Music music : mList) {
				int index = 0;
				if (name.equals(music.getTitle())) {
					return index;
				}

				index++;
			}
		}
		return 0;
	}

	// 곡 정보 수정
	public void modifyMusic(int index, Music music) {
		// TODO Auto-generated method stub

		System.out.print("곡명 : ");
		String title = Scanner.nextLine();
		System.out.print("가수명 : ");
		String singer = Scanner.nextLine();
		music.setSinger(title);
		music.setSinger(singer);
	}

// 곡 삭제
	public void deleteMusic(int index) {
		// TODO Auto-generated method stub
		mList.remove(index);
	}

	public void sortByTitleASC() {
		// collection - list, set, map 크기 - size()
//		List<String> strList = new ArrayList<String>();
//		strList.add("김만우");
//		strList.add("강지형");
//		strList.add("박은진");
//		Collection.sort(strList); // 기본 오름차순 정렬
		
		Collections.sort(mList, new DescTitle());
		
		
		//		int nums[] = { 4, 3, 2, 1 };
//		for (int i = 0; i < nums.length - 1; i++) {
//			for (int j = 0; j < i; j++) {
//				// 버블 정렬의 특징 - 오른쪽부터 정렬됨, 비교횟수
//				Music mOne = mList.get(i);
//				Music mTwo = mList.get(j + 1);
//				// 문제점 : 객체비교는 부등호로는 무리
//				// 비교해야 하는 것은 곡명(title)
//				// title을 서로 비교하여 ㄱ보다 늦은 순서인 경우 교체
//				// 문자열 비교는 equals()
//				// 비교했을 때 왼쪽이 크면 맨 오른쪽으로 보내라 -> 오른쪽 큰놈들만 쌓임 -> 오름차순 정렬
//				if (mOne.getTitle().compareTo(mTwo.getTitle()) > 0) {
////					Music temp = mOne;
////					mOne = mTwo;
////					mTwo = temp;
//					mList.set(j, mTwo);
//					mList.set(j + 1, mOne);
//
//				}
//
//			}
//		}
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	
	
	
	public void sortByTitleDESC() {
		// TODO Auto-generated method stub

	}

	public void sortBySingerASC() {
		// TODO Auto-generated method stub

	}

	public void sortBySingerDESC() {
		// TODO Auto-generated method stub

	}

}