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
 * @FileName : _2225.java
 * @Author : hyunyoungkim
 * @Date : Jan 23, 2019
 */
public class _2225 { // 합분해 : http://www.acmicpc.net/problem/2225

	/**
	 * @param args
	 */
	static int n, k;
	static int[][] d;
	static int MOD = 1000000000;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		d = new int[n+1][k+1];
		
/*		for (int i = 1; i <= k; i++) {
			for (int j = 0; j <= n; j++) {
				for (int l = 0; l <= j; l++) {
					d[i][j] += d[i - 1][j - l];
					d[i][j] %= MOD;
				}
			}
		}
		System.out.println(d[k][n]);          */
		
		for(int i=0;i<=k;i++) {
			d[0][i] = 1;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				d[i][j] = d[i-1][j] + d[i][j-1];
				d[i][j] %= MOD;
			}
		}
		System.out.println(d[n][k]);
	}

}
