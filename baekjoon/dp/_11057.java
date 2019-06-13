package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11057 { // 오르막수 : http://www.acmipc.net/problem/11057

	static int n;
	static long[][] d;
	static int MOD = 10007;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		d = new long[n + 1][10];

		for (int i = 0; i < 10; i++) {
			d[1][i] = 1; // 한자리 오르막수
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k <= j; k++) {
					d[i][j] += d[i - 1][k];
					d[i][j] %= MOD;
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < 10; i++) {
			ans += d[n][i];
		}
		System.out.println(ans % MOD);
	}

}
