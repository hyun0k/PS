package dp;

import java.io.*;
import java.util.StringTokenizer;

public class _1890 { // 점프 : https://www.acmicpc.net/problem/1890 
	static int[][] a;
	static int[][] d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		a = new int[n][n];
		d = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		d[0][0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int v = a[i][j];
				if (v == 0) {
					continue;
				}
				if(i+v<n) {
					d[i+v][j]+=d[i][j];
				}
				if(j+v<n) {
					d[i][j+v]+=d[i][j];
				}
			}
		}
		System.out.println(d[n - 1][n - 1]);
	}
}
