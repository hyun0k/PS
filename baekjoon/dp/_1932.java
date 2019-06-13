package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1932 { // 정수삼각형 : http://www.acmicpc.net/problem/1932

	static int n;
	static int[][] a;
	static int[][] d;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		a = new int[n + 1][n + 1];
		d = new int[n + 1][n + 1];

		// 2차원배열에 정수삼각형 저장.
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// dp
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if (j == 1) { 					// 삼각형 왼쪽 가장자리  
					d[i][j] = d[i - 1][j] + a[i][j];
				} else if (j == n) {			// 삼각형 오른쪽 가장자리
					d[i][j] = d[i - 1][j - 1] + a[i][j];
				} else {						// 삼각형 안쪽 
					d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + a[i][j];
				}
			}
		}

		// 마지막 층까지 실행된 d배열안에서 최댓값을 찾는다.
		int max = 0;
		for (int i = 1; i <= n; i++) {
			if (max < d[n][i]) {
				max = d[n][i];
			}
		}
		System.out.println(max);
	}

}
