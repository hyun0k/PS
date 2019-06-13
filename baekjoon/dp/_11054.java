package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11054 { // 가장 긴 바이토닉 부분 수열 : http://www.acmicpc.net/problem/11054

	static int n;
	static int[] a;
	static int[] ans;
	static int[][] d;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		a = new int[n];
		d = new int[2][n];
		ans = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			d[0][i] = d[1][i] = 1; // 초기화
		}

		for (int i = 1; i < n; i++) { // 왼 --> 오 LIS
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j]) {
					if (d[0][i] < d[0][j] + 1) {
						d[0][i] = d[0][j] + 1;
					}
				}
			}
		}

		for (int i = n - 2; i > 0; i--) { // 오 --> 왼 LIS
			for (int j = n - 1; j > i; j--) {
				if (a[i] > a[j]) {
					if (d[1][i] < d[1][j] + 1) {
						d[1][i] = d[1][j] + 1;
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			ans[i] = d[0][i] + d[1][i];
		}
		System.out.println(max(ans) - 1);
		printd(ans);
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
	private static void printd(int[] d) {
		System.out.println(Arrays.toString(d));
	}
}
