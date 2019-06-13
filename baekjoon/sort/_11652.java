/**
 * 
 */
package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Project : codePlus
 * @Package : sort
 * @FileName : _11652.java
 * @Author : hyunyoungkim
 * @Date : Feb 1, 2019
 */
public class _11652 { // 카드 : http://www.acmicpc.net/problem/11652

	/**
	 * @param args
	 */
	static int n;
	static long[] a;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		a = new long[n];

		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(br.readLine());
		}

		Arrays.sort(a);
		
		int cnt = 1;
		int ans_cnt = 1;
		long ans = a[0];
		for (int i = 1; i < n ; i++) {
			if (a[i] == a[i - 1]) {
				cnt++;
			} else {
				cnt = 1;
			}
			if (ans_cnt < cnt) {
				ans_cnt = cnt;
				ans = a[i];
			}
		}
		System.out.println(ans);
	}

}
