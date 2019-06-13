package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11051 { // 이항계수2 : http://www.acmicpc.net/problem/11051

	static int n, k;
	static int MOD = 10007;
	static int[][] d;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		d = new int[1001][1001];

		d[1][1] = d[1][0] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == j || j == 0) {
					d[i][j] = 1;
				} else {
					d[i][j] = d[i - 1][j - 1] + d[i - 1][j];
				}
				d[i][j] %= MOD;
			}
		}

		System.out.println(d[n][k]);
	}

}
