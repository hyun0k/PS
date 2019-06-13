/**
 * 
 */
package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Project : codePlus
 * @Package : sort
 * @FileName : _2751.java
 * @Author : hyunyoungkim
 * @Date : Jan 26, 2019
 */
public class _2751 { // 수 정렬하기2 : http://www.acmicpc.net/problem/2751

	/**
	 * @param args
	 */
	static int n;
	static int[] a;
	static int[] temp;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		a = new int[n];
		temp = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		mergeSort(a, 0, a.length - 1);
		printArray();
	}

	public static void mergeSort(int[] a, int first, int last) { // 합병 정렬 
		if (first < last) {
			int mid = (first + last) / 2;
			mergeSort(a, first, mid);
			mergeSort(a, mid + 1, last);
			merge(a, first, mid, last);
		}
	}

	public static void merge(int[] a, int first, int mid, int last) {

		int i = first;
		int j = mid + 1;
		int k = first;

		while (i <= mid && j <= last) {
			if (a[i] < a[j]) {
				temp[k++] = a[i++];
			} else {
				temp[k++] = a[j++];
			}
		}
		while (i <= mid) {
			temp[k++] = a[i++];
		}
		while (j <= last) {
			temp[k++] = a[j++];
		}
		for (i = first; i <= last; i++) {
			a[i] = temp[i];
		}
	}

	public static void printArray() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < n; i++) {
			result.append(a[i]);
			result.append(System.lineSeparator());
		}
		System.out.println(result);

	}
}
