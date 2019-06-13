package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4948 { // 베르트랑 공준 : http://www.acmicpc.net/problem/4948

	static int n;
	static int MAX = 246912;
	static int[] a;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// n이 최대 123456이므로 246912 까지의 소수를 모두 구해놓는다. 에라토스테네스의 체 알고리즘 이용. 
		a = new int[MAX + 1];

		for (int i = 2; i <= MAX; i++) {
			a[i] = i;
		}

		for (int i = 2; i <= MAX; i++) {
			if (a[i] == 0) {
				continue;
			} else {
				for (int j = i + i; j <= MAX; j += i) {
					a[j] = 0;
				}
			}
		}

		// n보다 크고 2*n보다 작거나 같은 소수의 개수를 센다.  
		while (true) {

			n = Integer.parseInt(br.readLine());

			if (n == 0) {
				break;
			} else {
				int cnt = 0;
				for (int i = n; i <= 2 * n; i++) {
					if (a[i] == 0 || i == n) {
						continue;
					} else {
						cnt++;
					}
				}
				sb.append(cnt).append(System.lineSeparator());
			}
		}
		System.out.println(sb);

	}

}
