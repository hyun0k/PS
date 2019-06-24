package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2589 { // 보물섬 : http://www.acmicpc.net/problem/2589

	/**
	 * 최단거리 문제이므로 bfs. 두 지점의 최단경로의 최댓값을 찾아야함. 
	 */
	static int N, M, ans, max;
	static char[][] map;
	static int[][] dist;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		dist = new int[N][M];
		visited = new boolean[N][M];

		ans = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		explore();

		System.out.println(ans);
	}

	private static void explore() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L' && !visited[i][j]) {
					visited[i][j] = true;
					bfs(j, i);
					ans = Math.max(ans, max);
					max = Integer.MIN_VALUE;           // max 초기화.
					for (boolean row[] : visited) {    // visited 초기화.
						Arrays.fill(row, false);
					}
					for (int row[] : dist) {          // dist 초기화.
						Arrays.fill(row, 0);
					}
				}
			}
		}
	}

	private static void bfs(int x, int y) {

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));

		while (!q.isEmpty()) {
			Point p = q.poll();
			int curX = p.x;
			int curY = p.y;
			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
					continue;
				}
				if (map[nextY][nextX] == 'W' || visited[nextY][nextX]) {
					continue;
				}
				visited[nextY][nextX] = true;
				dist[nextY][nextX] = dist[curY][curX] + 1;
				q.add(new Point(nextX, nextY));

			}
		}
		for (int i = 0; i < N; i++) {			// dist에서 최댓값찾기. 
			for (int j = 0; j < M; j++) {
				max = Math.max(max, dist[i][j]);
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
