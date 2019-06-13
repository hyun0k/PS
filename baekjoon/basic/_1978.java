package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1978 { // 소수 찾기 : http://www.acmicpc.net/problem/1978

	static int n;
	static int[] a;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		a = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			int temp = a[i];
			boolean isPrime = true;
			if (temp == 1) {
				isPrime = false;
				continue;
			} else {
				for (int j = 2; j < temp; j++) {
					if (temp % j == 0) {
						isPrime = false;
						break;
					}
				}
			}

			if (isPrime) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

}
