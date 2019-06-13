package Advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _1249 { // 보급로

	static int T, N, ans;
	static int[][] map, cost;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			cost = new int[N][N];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
					cost[i][j] = Integer.MAX_VALUE;
				}
			}

			bfs();
			ans = cost[N - 1][N - 1];

			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}

	static void bfs() {

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0));
		cost[0][0] = 0;

		while (!q.isEmpty()) {
			Node v = q.poll();
			int curX = v.x;
			int curY = v.y;
			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
					continue;
				}
				if (cost[nextX][nextY] > cost[curX][curY] + map[nextX][nextY]) { 
					cost[nextX][nextY] = cost[curX][curY] + map[nextX][nextY];
					q.add(new Node(nextX, nextY));
				}

			}
		}
	}

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
