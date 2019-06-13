package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1463 { // 1로 만들기 : https://www.acmicpc.net/problem/1463

	static int N;
	static int[] d;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		d = new int[N + 1];

		d[1] = 0;
		for (int i = 2; i <= N; i++) {
			d[i] = d[i - 1] + 1;
			if (i % 2 == 0 && d[i] > d[i / 2] + 1) {
				d[i] = d[i / 2] + 1;
			}
			if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
				d[i] = d[i / 3] + 1;
			}

		}
		System.out.println(d[N]);
	}

}
