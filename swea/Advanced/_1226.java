package Advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _1226 { // 미로

	static int T, ans;
	static int[][] map;
	static boolean[][] visited;
	static Point start;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {

			T = Integer.parseInt(br.readLine());
			map = new int[16][16];
			visited = new boolean[16][16];
			for (int i = 0; i < 16; i++) {
				String str = br.readLine();
				for (int j = 0; j < 16; j++) {
					map[i][j] = str.charAt(j) - '0';
					visited[i][j] = false;
					if (map[i][j] == 2) {
						start = new Point(i, j);
					}
				}
			}
			ans = 0;
			visited[start.x][start.y] = true;
			bfs(start);

			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}

	private static void bfs(Point p) {
		Queue<Point> q = new LinkedList<>();
		q.offer(p);
		while (!q.isEmpty()) {
			Point cur = q.poll();
			int curX = cur.x;
			int curY = cur.y;
			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				if (map[nextX][nextY] == 3) {
					ans = 1;
					break;
				}
				if (nextX < 0 || nextY < 0 || nextX >= 16 || nextY >= 16) {
					continue;
				}
				if (visited[nextX][nextY] || map[nextX][nextY] == 1) {
					continue;
				}
				q.offer(new Point(nextX, nextY));
				visited[nextX][nextY] = true;
			}

		}
	}

	private static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
