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
 * @FileName : __9461.java
 * @Author : hyunyoungkim
 * @Date : Jan 18, 2019
 */
public class __9461 {

	/**
	 * @param args
	 */
	static int n;
	static int test_case;
	static long[] d;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		test_case = Integer.parseInt(br.readLine());
		for (int t = 0; t < test_case; t++) {
			n = Integer.parseInt(br.readLine());
			d = new long[101];
			d[1] = d[2] = d[3] = 1;
			for (int i = 4; i <= n; i++) {
				d[i] = d[i - 3] + d[i - 2];
			}
			System.out.println(d[n]);
		}
	}

}
