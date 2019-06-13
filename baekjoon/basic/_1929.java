package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1929 { // 소수구하기 : http://www.acmicpc.net/problem/1929
	/**
	 * 에라토스테네스의 체 알고리즘을 이용한다.
	 */

	static int m, n;
	static int[] a;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		a = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			a[i] = i;
		}

		for (int i = 2; i <= n; i++) {
			if (a[i] == 0) {
				continue;
			} else {
				for (int j = i + i; j <= n; j += i) { // 자기 자신을 제외한 배수를 모두 0으로 바꾼다. 
					a[j] = 0;
				}
			}
		}

		for (int i = m; i <= n; i++) {
			if (a[i] == 0) {
				continue;
			} else {
				sb.append(a[i]).append(System.lineSeparator());
			}
		}

		System.out.println(sb);
	}

}
