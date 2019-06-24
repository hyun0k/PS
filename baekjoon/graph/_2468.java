package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2468 { // 안전영역 : //http://www.acmicpc.net/problem/2468

	static int N, pptn, max, cnt, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];

		ans = Integer.MIN_VALUE; // 안전영역 최대개수 
		max = Integer.MIN_VALUE; // map의 최대높이 
		pptn = 0; 				 // 강수량 

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}

		flood();

		System.out.println(ans);
	}

	private static void flood() {
		while (pptn < max) {
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] <= pptn) {
						map[i][j] = 0; // 침수된 곳은 0
					}
				}
			}
			for (boolean row[] : visited) {
				Arrays.fill(row, false);
			}
			explore();
			ans = Math.max(ans, cnt);
			pptn++;
		}
		return;
	}

	private static void explore() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					visited[i][j] = true;
					dfs(j, i);
					cnt++;
				}
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
			visited[nextY][nextX] = true;
			dfs(nextX, nextY);
		}

	}

}
