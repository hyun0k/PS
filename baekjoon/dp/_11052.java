/**
 * 
 */
package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Project : codePlus
 * @Package : dp
 * @FileName : _11052.java
 * @Author : hyunyoungkim
 * @Date : Jan 18, 2019
 */
public class _11052 { // 카드 구매하기 : http://www.acmicpc.net/problem/11052

	/**
	 * @param args
	 */
	static int n;
	static int[] p;
	static int[] d;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		p = new int[n + 1];
		d = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				d[i] = Math.max(p[j] + d[i - j], d[i]);
			}
		}
		System.out.println(d[n]);
	}

}
