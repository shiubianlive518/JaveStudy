package com.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author MarvinTeng
 */
public class BubbleSort {
	private static void sort_v1(int[] array) {
		int tmp = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
		}
	}

	private static void sort_v2(int[] array) {
		int tmp = 0;
		for (int i = 0; i < array.length; i++) {
			boolean isSorted = true;//有序标记，每一轮的初始是true
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
					
					isSorted = false;//有元素交换，所以不是有序，标记变为false
				}
			}
			
			if (isSorted) {
				break;
			}
		}
	}

	private static void sort_v3(int[] array) {
		int tmp = 0;
		int lastExchangeIndex = 0;//记录最后一次交换的位置
		int sortBorder = array.length - 1;//无序数列的边界，每次比较只需要比到这里为止
		for (int i = 0; i < array.length; i++) {
			boolean isSorted = true;//有序标记，每一轮的初始是true
			for (int j = 0; j < sortBorder; j++) {
				if (array[j] > array[j + 1]) {
					tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
					
					isSorted = false;//有元素交换，所以不是有序，标记变为false
					lastExchangeIndex = j;//把无序数列的边界更新为最后一次交换元素的位置
				}
			}
			sortBorder = lastExchangeIndex;
			
			if (isSorted) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[] { 5, 8, 6, 3, 9, 2, 1, 7 };
		BubbleSort.sort_v1(array);
		System.out.println(Arrays.toString(array));

		array = new int[] { 5, 8, 6, 3, 9, 2, 1, 7 };
		BubbleSort.sort_v2(array);
		System.out.println(Arrays.toString(array));

		array = new int[] { 3, 4, 2, 1, 5, 6, 7, 8 };
		BubbleSort.sort_v3(array);
		System.out.println(Arrays.toString(array));
	}
}