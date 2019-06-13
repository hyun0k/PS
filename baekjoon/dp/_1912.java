package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1912 { // 연속합 : http://www.acmicpc.net/problem/1912

	static int n;
	static int[] a;
	static int[] d;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		a = new int[n];
		d = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		d[0] = a[0];
		for (int i = 1; i < n; i++) {
			d[i] = Math.max(d[i - 1] + a[i], a[i]);
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
