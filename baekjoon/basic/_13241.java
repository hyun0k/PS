package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13241 { // 최소공배수 : http://www.acmicpc.net/problem/13241
	/**
	 * 유클리드 호제법을 이용한다.
	 */
	static long a, b;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());

		System.out.println(a * b / gcd(a, b));

	}

	static long gcd(long x, long y) {
		return (y == 0) ? x : gcd(y, x % y);
	}
}
