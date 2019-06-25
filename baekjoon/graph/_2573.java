package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2573 { // 빙산 : http://www.acmicpc.net/problem/2573 
	
	/**
	 *  빙산이 다 녹을때까지 분리되지 않으면 0을 출력하는 조건을 잊으면 안된다.
	 *  빙하가 다 녹아서 없어지면 반복문을 종료하도록 해야한다. 
	 */

	static int N, M, ans, cntIce, cntYear;
	static int[][] map, melt;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		melt = new int[N][M];		// 녹는 빙하량 저장할 배열. 
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		melting();
		ans = (cntIce >= 2) ? cntYear : 0;

		System.out.println(ans);
	}

	private static void melting() {
		while (true) {
			if (cntIce >= 2) {	// 빙하 개수가 2개 이상되면 break. 
				break;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					getAdjSea(j, i);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0) {
						map[i][j] -= melt[i][j];
						if (map[i][j] < 0) {
							map[i][j] = 0;
						}
					}
				}
			}
			for (int[] row : melt) {			// melt 배열 초기화.
				Arrays.fill(row, 0);
			}
			for (boolean[] row : visited) {   	// visited 배열 초기화. 
				Arrays.fill(row, false);
			}
			cntIce = 0; 						// 빙하 개수 초기화. 
			
			explore();
			cntYear++;
			
			if (cntIce == 0) {	// 빙하가 다 녹아없어지면 break. 
				break;
			}
		}
	}

	private static void getAdjSea(int x, int y) {   // 바다에 인접한 면 카운트. 녹일 빙하량 저장. 
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
				continue;
			}
			if (map[nextY][nextX] == 0) {
				melt[y][x]++;
			}
		}
	}

	private static void explore() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					visited[i][j] = true;
					dfs(j, i);
					cntIce++;
				}
			}
		}
	}

	private static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
				continue;
			}
			if (map[nextY][nextX] == 0 || visited[nextY][nextX]) {
				continue;
			}
			visited[nextY][nextX] = true;
			dfs(nextX, nextY);
		}
	}
}
