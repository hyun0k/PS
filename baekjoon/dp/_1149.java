package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1149 { // RGB거리 : http//www.acmicpc.net/problem/1149

	static int n;
	static int[][] d;
	static int[][] cost;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		d = new int[n + 1][3];
		cost = new int[n + 1][3];

		// 배열에 비용 저장. 안헷갈리게 배열의 0번째는 비워두고 1번째부터 사용.
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// dp
		for (int i = 1; i <= n; i++) {

			d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + cost[i][0];
			d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + cost[i][1];
			d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + cost[i][2];

		}

		System.out.println(Math.min(Math.min(d[n][0], d[n][1]), d[n][2]));
	}

}
