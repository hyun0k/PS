/**
 * 
 */
package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @Project : codePlus
 * @Package : sort
 * @FileName : _11651.java
 * @Author : hyunyoungkim
 * @Date : Jan 29, 2019
 */
public class _11651 { // 좌표 정렬하기2 : http://www.acmicpc.net/problem/11651

	/**
	 * @param args
	 */
	static int n;
	static int[][] a;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		a = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(a, new Comparator<int[]>() { // Overriding ?? compare ??
			public int compare(int[] x, int[] y) {
				if (x[1] == y[1]) {
					return Integer.compare(x[0], y[0]);
				} else {
					return Integer.compare(x[1], y[1]);
				}
			}
		});

		for (int i = 0; i < n; i++) {
			sb.append(a[i][0] + " " + a[i][1]).append(System.lineSeparator());
		}

		System.out.println(sb);
	}

}
