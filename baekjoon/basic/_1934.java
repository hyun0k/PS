package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1934 { // 최소공배수 : http://www.acmicpc.net/problem/1934
	/**
	 * 유클리드 호제법을 이용한다.
	 */
	static int test_case, a, b;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		test_case = Integer.parseInt(br.readLine());

		for (int i = 0; i < test_case; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			sb.append(a * b / gcd(a, b)).append(System.lineSeparator());
		}

		System.out.println(sb);

	}

	static int gcd(int x, int y) {
		return (y == 0) ? x : gcd(y, x % y);
	}
}
