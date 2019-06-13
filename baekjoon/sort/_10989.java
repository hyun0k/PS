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
 * @FileName : _10989.java
 * @Author : hyunyoungkim
 * @Date : Jan 31, 2019
 */
public class _10989 { // 수 정렬하기3 : http://www.acmicpc.net

	/**
	 * @param args
	 */
	static int n;
	static int MAX = 10001;
	static int[] a;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		a = new int[MAX];

		for (int i = 0; i < n; i++) {
			a[Integer.parseInt(br.readLine())]++;
		}

		for (int i = 0; i < MAX; i++) {
			if (a[i] > 0) {
				for (int j = 0; j < a[i]; j++) {
					sb.append(i).append(System.lineSeparator());
				}
			}
		}
		System.out.println(sb);
	}

}
