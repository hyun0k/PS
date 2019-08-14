package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14500 { // 테트로미노 : http://www.acmicpc.net/problem/14500

	static int N, M, max;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		max = Integer.MIN_VALUE;

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		explore();

		System.out.println(max);
	}

	private static void explore() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(j, i, 1, map[i][j]);
				specialCase(j, i);
			}
		}
	}

	private static void dfs(int x, int y, int cnt, int sum) {

		if (cnt == 4) {
			max = Math.max(max, sum);
			return;
		}

		visited[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX >= 0 && nextY >= 0 && nextX < M && nextY < N && !visited[nextY][nextX]) {
				dfs(nextX, nextY, cnt + 1, sum + map[nextY][nextX]);
			}
		}

		visited[y][x] = false;
	}

	private static void specialCase(int x, int y) { // 'ㅏ'모양만 따로 처리 

		for (int i = 0; i < 4; i++) {
			int sum = map[y][x];

			for (int j = 0; j < 3; j++) {
				int nextX = x + dx[(i + j) % 4];
				int nextY = y + dy[(i + j) % 4];

				if (nextX >= 0 && nextY >= 0 && nextX < M && nextY < N) {
					sum += map[nextY][nextX];
				}
			}
			max = Math.max(max, sum);
		}

	}
}
