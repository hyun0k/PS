package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1699 { // 제곱수의 합 : http://www.acmicpc.net/problem/1699

	static int n;
	static int[] d;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		d = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			d[i] = i;
			for (int j = 1; j * j <= i; j++) {
				d[i] = Math.min(d[i - j * j] + 1, d[i]);
			}
		}
		System.out.println(d[n]);
	}

}
