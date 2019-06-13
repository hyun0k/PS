package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10844 { // 쉬운 계단수 : https://www.acmicpc.net/problem/10844

	static int N;
	static int[][] d;
	static int MOD = 1000000000;

	static void solve(int N) {

		for (int i = 1; i <= 9; i++) {
			d[1][i] = 1; 		// 한자리 계단수는 1개
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				d[i][j] = 0;
				if (j - 1 >= 0) {
					d[i][j] += d[i - 1][j - 1];
				}
				if (j + 1 <= 9) {
					d[i][j] += d[i - 1][j + 1];
				}
				d[i][j] = d[i][j] % MOD;
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		d = new int[N + 1][10];

		solve(N);

		long ans = 0;
		for (int i = 0; i <= 9; i++) {
			ans += d[N][i];
		}

		System.out.println(ans % MOD);
	}

}
