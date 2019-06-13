package dp;

import java.util.StringTokenizer;
import java.math.*;
import java.io.*;

public class _11048 { // 이동하기 : https://www.acmicpc.net/problem/11048
	static int[][] a;
	static int[][] d;

	public static int go(int x, int y) {
		if (x < 0 || y < 1) {
			return 0;
		}
		if (d[x][y] >= 0) {
			return d[x][y];
		}
		d[x][y] = Math.max(go(x - 1, y), go(x, y - 1)) + a[x][y];
		return d[x][y];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		a = new int[n + 1][m + 1];
		d = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				d[i][j] = -1;
			}
		}
		System.out.println(go(n, m));

	}

}
