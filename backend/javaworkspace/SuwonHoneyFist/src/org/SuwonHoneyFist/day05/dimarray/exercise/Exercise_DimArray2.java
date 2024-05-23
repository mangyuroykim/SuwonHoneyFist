package org.SuwonHoneyFist.day05.dimarray.exercise;

public class Exercise_DimArray2 {
	public static void main(String[] args) {
		// 숫자 5행에 5열 짜리 오른쪽에서 왼쪽으로 출력되게
		int[][] nums = new int[5][5];
		int count = 1; //1부터 시작하는 이유는 숫자 1을 넣는다는게 아니라 
						//"첫번째" 반복용도로 쓰려고
		for (int i = 0; i < nums.length; i++) { //nums.length자리는 이미 위에서 5개로 정의되어서 < 6이라고 써도되는데 굳이 그때그때 숫자 입력할거없이 "정해놓은 범위만큼" 이라는 뜻으로 쓰임
			for (int j = 0; j < nums[i].length; j++) {
				nums[i][j] = count++;
			} //j에다가 입력값을 반복해서 넣은걸 범위만큼 반복하겠다는 뜻
			//////// 위에는 만든 배열에 값 넣는것 아래는 넣은 값을 거꾸로 출력
		}
		for(int i = 0; i <nums.length; i++) {
			for(int j = nums[i].length -1; j >= 0; j--) {//nums[i].length -1 이란 뜻은 길이가 총 얼마얼마 있는데 거기서 1뺀값이란 소린데 이게 통상적으로 인덱스값이 0부터 시작하니까 행이든 열이든 총 길이에 -1한값은 마지막 인덱스 위치라는 표현이고 gpt도 이거말고 표현할 다른방법 없다니까 외우기
				System.out.print(nums[i][j] + "\t");
			}
			System.out.println();
		}
	
	}
}
