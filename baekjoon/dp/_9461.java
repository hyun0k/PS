package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9461 { // 파도반 수열 : https://www.acmicpc.net/problem/9461

	static int N, test_case;
	static long[] d;

	static long pado(int N) {
		if (N <= 3) {
			return 1;
		} else {
			if (d[N] > 0) {
				return d[N];
			}
			d[N] = pado(N - 3) + pado(N - 2);
			return d[N];
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		test_case = Integer.parseInt(br.readLine());

		for (int t = 0; t < test_case; t++) {

			N = Integer.parseInt(br.readLine());
			d = new long[N + 1];

			System.out.println(pado(N));
		}
	}

}
