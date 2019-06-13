package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class _2407 { // 조합 : http://www.acmicpc.net/problem/2407
	
	/**
	 * 숫자의 범위가 커서 int, long 으로도 부족함. 따라서 BigInteger를 사용해서 풀어야함. 
	 */
	
	static int n, m;
	static BigInteger[][] d;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger bi = new BigInteger("1");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = new BigInteger[1001][1001];

		d[1][1] = d[1][0] = bi;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == j || j == 0) {
					d[i][j] = bi;
				} else {
					d[i][j] = d[i - 1][j - 1].add(d[i - 1][j]);
				}
			}
		}

		System.out.println(d[n][m]);

	}

}
