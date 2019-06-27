package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2146 { // 다리만들기 : http://www.acmicpc.net/problem/2146
	
	/**
	 * dfs로 섬을 구분지은 다음 bfs로 서로 다른 섬을 잇는 최단 거리를 구한다. 다리를 놓을때
	 * 초기화를 해야한다.   
	 */
	static int N, ans, min, idx;
	static int[][] map, dist;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		dist = new int[N][N];
		visited = new boolean[N][N];

		ans = Integer.MAX_VALUE;
		idx = 1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					map[i][j] = -1; // 섬이면 -1
				}
			}
		}

		explore();

		for (boolean[] row : visited) {
			Arrays.fill(row, false);
		}

		buildBrg();

		System.out.println(ans);
	}

	private static void buildBrg() {  // 다리 놓기. 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				min = Integer.MAX_VALUE;
				for (boolean[] row : visited) {
					Arrays.fill(row, false);
				}
				for (int[] row : dist) {
					Arrays.fill(row, 0);
				}
				if (map[i][j] != 0 && !visited[i][j]) {
					visited[i][j] = true;
					bfs(j, i);
					ans = Math.min(ans, min);
				}
			}
		}
	}

	private static void explore() { // 섬 라벨링. 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == -1 && !visited[i][j]) {
					map[i][j] = idx;
					visited[i][j] = true;
					dfs(j, i);
					idx++;
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
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
					continue;
				}
				if (visited[nextY][nextX] || map[nextY][nextX] == map[y][x]) {	
					continue;
				}
				if (map[y][x] != map[nextY][nextX] && map[nextY][nextX] != 0) {
					min = Math.min(min, dist[curY][curX]);
					break;
				}
				visited[nextY][nextX] = true;
				dist[nextY][nextX] = dist[curY][curX] + 1;
				q.add(new Point(nextX, nextY));
			}
		}
	}

	private static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
				continue;
			}
			if (visited[nextY][nextX] || map[nextY][nextX] == 0) {
				continue;
			}
			map[nextY][nextX] = idx;
			visited[nextY][nextX] = true;
			dfs(nextX, nextY);
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
