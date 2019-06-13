package Advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1247 { // 최적 경로

	static int T, N, ans;
	static boolean[] visited;
	static Point[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			ans = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());

			arr = new Point[N + 2]; // arr[0]:회사, arr[1]:집
			visited = new boolean[N + 2];
			for (int i = 0; i < N + 2; i++) {
				arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				visited[i] = false;
			}

			dfs(0, 0, 0);
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}

	static void dfs(int k, int sum, int from) {
		if (k == N) {
			sum += dist(arr[1], arr[from]);
			ans = Math.min(ans, sum);
			return;
		}
		for (int i = 2; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(k + 1, sum + dist(arr[i], arr[from]), i);
				visited[i] = false;

			}
		}
	}

	static int dist(Point a, Point b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
