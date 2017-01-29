package br.com.rodrigo.mergesort;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] array = new int[] {8, 4, 1, 5, 9, 2};
		mergeSort(array);
		for (int value : array) {
			System.out.print(value + ", ");
		}
	}
	
	public static void mergeSort(int[] array) {
		int[] temp = new int[array.length];
		split(array, temp, 0, array.length -1);
	}
	
	public static void split(int[] array, int[] temp, int leftStart, int rightEnd) {
		if (leftStart >= rightEnd) {
			return;
		}
		int middle = (leftStart + rightEnd) / 2;
		split(array, temp, leftStart, middle); // Sort left half
		split(array, temp, middle + 1, rightEnd); // Sort right half
		mergeHalves(array, temp, leftStart, middle, rightEnd);
	}

	private static void mergeHalves(int[] array, int[] temp, int leftStart, int middle, int rightEnd) {
		for (int i = leftStart; i <= rightEnd; i++) {
			temp[i] = array[i];
		}
		
		int left = leftStart;
		int right = middle + 1;
		int current = leftStart;
		
		while(left <= middle && right <= rightEnd) {
			if (temp[left] <= temp[right]) {
				array[current] = temp[left];
				left++;
			} else {
				array[current] = temp[right];
				right++;
			}
			current++;
		}
		
		int remaining = middle - left;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = temp[left + i];
		}
		
//		int leftEnd = (rightEnd + leftStart) / 2;
//		int rightStart = leftEnd + 1;
//		int size = rightEnd - leftStart + 1;
//		
//		int left = leftStart;
//		int right = rightStart;
//		int index = leftStart;
//		
//		while (left <= leftEnd && right <= rightEnd) {
//			if (array[left] <= array[right]) {
//				temp[index] = array[left];
//				left++;
//			} else {
//				temp[index] = array[right];
//				right++;
//			}
//			index++;
//		}
//		
//		System.arraycopy(array, left, temp, index, leftEnd - left + 1);
//		System.arraycopy(array, right, temp, index, rightEnd - right + 1);
//		System.arraycopy(temp, leftStart, array, leftStart, size);
		
	}

}
