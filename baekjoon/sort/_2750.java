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
 * @FileName : _2750.java
 * @Author : hyunyoungkim
 * @Date : Jan 25, 2019
 */
public class _2750 { // 수 정렬하기 : http://www.acmicpc.net/problem/2750

	/**
	 * @param args
	 */
	static int n;
	static int[] a;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		for (int i = a.length; i > 0; i--) {        // Bubble sort 
			for (int j = 0; j < n - i  ; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < n; i++) {
			result.append(a[i]);
			result.append(System.lineSeparator());
		}
		System.out.println(result);
	}

}
