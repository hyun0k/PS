package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9465 { // 스티커 : http://www.acmicpc.net//9465

	static int test_case, n;
	static int[][] a;
	static int[][] d;

	public static void main(String arg[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		test_case = Integer.parseInt(br.readLine());

		while (test_case-- > 0) {
			n = Integer.parseInt(br.readLine());
			a = new int[n + 1][2];
			d = new int[n + 1][3];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					a[j][i] = Integer.parseInt(st.nextToken());
				}
			}

			d[1][0] = 0;
			d[1][1] = a[1][0];
			d[1][2] = a[1][1];

			for (int i = 2; i <= n; i++) {
				d[i][0] = Math.max(d[i - 1][0], Math.max(d[i - 1][1], d[i - 1][2]));
				d[i][1] = Math.max(d[i - 1][0], d[i - 1][2]) + a[i][0];
				d[i][2] = Math.max(d[i - 1][0], d[i - 1][1]) + a[i][1];
			}
			int ans = Math.max(d[n][0], Math.max(d[n][1], d[n][2]));
			System.out.println(ans);
		}
	}

}
