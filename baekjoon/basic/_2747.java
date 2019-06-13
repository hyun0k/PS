package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2747 { // 피보나치 수 : http://www.acmicpc.net/problem/2747

	static int n;
	static int[] d;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		d = new int[n + 1];

		d[0] = 0;
		d[1] = 1;
		for (int i = 2; i <= n; i++) {
			d[i] = d[i - 2] + d[i - 1];
		}

		System.out.println(d[n]);
	}

}
