package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1012 { // 유기농 배추 : http://www.acmicpc.net/problem/1012

	/**
	 *  단지 번호 붙이기 문제와 유사함. dfs가 끝날때 cnt를 증가시켜주는것이 다른점.
	 *  (단지번호붙이기에서는 매 dfs마다 cnt증가)  
	 */
	
	static int T, M, N, K, cnt;
	static int[][] farm;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			farm = new int[N][M];
			visited = new boolean[N][M];
			for (boolean[] row : visited) {
				Arrays.fill(row, false);
			}

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				farm[y][x] = 1;
			}

			explore();

			sb.append(cnt + "\n");
			cnt = 0; // 테스트케이스마다 초기화!!
		}
		System.out.println(sb);

	}

	private static void explore() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (farm[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					dfs(i, j);
					cnt++;
				}
			}
		}
	}

	private static void dfs(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
				continue;
			}
			if (visited[nextY][nextX] || farm[nextY][nextX] == 0) {
				continue;
			}
			visited[nextY][nextX] = true;
			dfs(nextY, nextX);
		}
	}

}
