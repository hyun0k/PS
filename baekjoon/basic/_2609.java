package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2609 { // 최대공약수와 최소공배수 : http://www.acmipcp.net/problem/2609

	static int a, b;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		sb.append(gcd(a, b)).append(System.lineSeparator());
		sb.append(a * b / gcd(a, b));

		System.out.println(sb);

	}

	static int gcd(int x, int y) {
		return (y == 0) ? x : gcd(y, x % y);
	}

}
