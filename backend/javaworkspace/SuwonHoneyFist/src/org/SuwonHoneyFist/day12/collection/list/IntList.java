package org.SuwonHoneyFist.day12.collection.list;

public class IntList {
    int[] nums;
    int size;

    public IntList() {
        nums = new int[3];
        size = 0;
    }

    public void add(int num) {
        if (size == nums.length) {
            // 배열 크기를 늘림
            int[] newNums = new int[nums.length * 2];
            for (int i = 0; i < nums.length; i++) {
                newNums[i] = nums[i];
            }
            nums = newNums;
        }
        nums[size] = num;
        size++;
    }

    public int get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return nums[index];
    }

    public int size() {
        return size;
    }

    public void clear() {
        nums = new int[3];
        size = 0;
    }
}
