package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9020 { // 골드바흐의 추측 : http://www.acmicpc.net/problem/9020

	static int T, n;
	static int[] a;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		a = new int[10001];

		// 먼저 10000까지 소수를 모두 구해놓는다. 에라토스테네스의 체 사용.

		for (int i = 2; i <= 10000; i++) {
			a[i] = i;
		}

		for (int i = 2; i <= 10000; i++) {
			if (a[i] == 0) {
				continue;
			} else {
				for (int j = i + i; j <= 10000; j += i) {
					a[j] = 0;
				}
			}
		}

		// 짝수를 이루는 가장 작은 차이가 나는 소수 2개는 짝수의 절반값을 기준으로 그 차이값이 동일하다.
		
		while (T-- > 0) {
			n = Integer.parseInt(br.readLine());
			int val1 = 0;
			int val2 = 0;
			for (int i = n / 2; i <= 10000; i++) {
				if (a[i] == 0) {
					continue;
				} else {
					if (a[i] != 0 && a[n - i] != 0) { 
						val2 = a[i];
						val1 = a[n - i];
						break;
					}
				}
			}
			sb.append(val1 + " " + val2).append(System.lineSeparator());
		}
		System.out.println(sb);

	}

}
