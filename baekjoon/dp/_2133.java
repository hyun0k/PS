/**
 * 
 */
package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Project : codePlus
 * @Package : dp
 * @FileName : _2133.java
 * @Author : hyunyoungkim
 * @Date : Jan 17, 2019
 */
public class _2133 { // 타일채우기 : http://www.acmicpc.net/problem/2133

	/**
	 * @param args
	 */

	static int n;
	static int[] d;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		d = new int[n + 1];

		d[0] = 1;
		for (int i = 2; i <= n; i += 2) {
			d[i] = 3 * d[i - 2];
			for (int j = 4; i - j >= 0; j += 2) {
				d[i] += 2 * d[i - j];
			}
		}

		System.out.println(d[n]);
	}

}
