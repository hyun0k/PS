package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1065 { // 한수 : http://www.acmicpc.net/problem/1065

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		if (N < 100) {
			System.out.println(N);
		} else {
			int cnt = 0;
			for (int i = 101; i <= N; i++) {
				int a = i / 100;
				int b = (i % 100) / 10;
				int c = (i % 100) % 10;
				if (b - a == c - b) {
					cnt++;
				}
			}
			System.out.println(cnt+99);
		}

	}

}
