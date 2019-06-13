package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11055 { // 가장 큰 증가 부분수열 : http//www.acmicpc.net/problem/11055

	static int n;
	static int[] a;
	static int[] d;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		a = new int[n];
		d = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			d[i] = a[i]; // 초기화
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j]) {
					if (d[i] < d[j] + a[i]) {
						d[i] = d[j] + a[i];
					}
				}
			}
		}

		System.out.println(max(d));
	}

	private static int max(int[] d) {
		int max = d[0];
		for (int i = 0; i < d.length; i++) {
			if (max < d[i]) {
				max = d[i];
			}
		}
		return max;
	}

}
