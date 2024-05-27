package org.SuwonHoneyFist.day05.dimarray.exercise;

import java.util.Scanner;

public class Exercise_DimArray {

    public void practiceDimArray1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("1~10 사이의 정수를 입력 해주세요: ");
        int num = sc.nextInt();
        while (num < 1 || num > 10) {
            System.out.println("반드시 1~10 사이의 정수를 입력해주세요");
            System.out.print("1~10 사이의 정수를 입력 해주세요: ");
            num = sc.nextInt();
        }

        char[][] nums = new char[num][num];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] = (char) ('a' + (int) (Math.random() * 26));
            }
        }

        // 2차원 배열 출력
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void practiceDimArray2() {
        int[][] nums = new int[5][5];
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] = count++;
            }
        }

        // 배열 출력
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i].length - 1; j >= 0; j--) {
                System.out.print(nums[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void practiceDimArray3() {
        int[][] arrs = new int[5][5];
        int k = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 4; j >= 0; j--) {
                arrs[j][i] = k++;
            }
        }
        for (int[] arr : arrs) {
            for (int num : arr) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }

    public void practiceDimArray4() {
        int[][] arrs = new int[5][5];
        int k = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arrs[j][i] = k++;
            }
        }
        for (int[] arr : arrs) {
            for (int num : arr) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }

    public void practiceDimArray5() {
        int[][] arrs = new int[5][5];
        int k = 1;
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 5; j++) {
                    arrs[i][j] = k++;
                }
            } else {
                for (int j = 4; j >= 0; j--) {
                    arrs[i][j] = k++;
                }
            }
        }
        for (int[] arr : arrs) {
            for (int num : arr) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}
