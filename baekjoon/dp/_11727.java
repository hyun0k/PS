package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11727 { // 2xN타일링2 : https://www.acmicpc.net/problem/11727

	static int N;
	static int[] d;

	static int solve(int N) {
		d[0] = 1;
		d[1] = 1;
		for (int i = 2; i <= N; i++) {
			d[i] = (d[i - 1] + 2 * d[i - 2]) % 10007;
		}
		return d[N];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		d = new int[N + 1];

		System.out.println(solve(N));
	}

}
