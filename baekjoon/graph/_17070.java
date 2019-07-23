package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17070 { // 파이프 옮기기1 : http://www.acmicpc.net/problem/17070

	/**
	 * 파이프를 가로 세로 방향으로 이동할때는 그 다음칸만 벽이 아니면 가능하지만 대각선 방향으로 이동할때는 주변 3칸이 모두 벽이 아니여야
	 * 가능하다. 이것에 주의하자.
	 */

	static int N, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 1, 0, 1 };
	static int[] dy = { 0, 1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];

		cnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(1, 0, 0);

		System.out.println(cnt);

	}

	private static boolean checkAround(int x, int y) {

		for (int i = 0; i < 3; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if (map[nextY][nextX] == 1) {
				return false;
			}
		}
		return true;
	}

	private static void dfs(int curX, int curY, int con) { // con : 현재 놓인 상태
															// 0:가로, 1:세로, 2:대각선
		if (curX == N - 1 && curY == N - 1) {
			cnt++;
			return;
		}

		visited[curY][curX] = true;
		int curCon = con;

		for (int i = 0; i < 3; i++) { // i : 0:오른쪽 1:아래 2:대각선
			int nextX = curX + dx[i];
			int nextY = curY + dy[i];

			if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {

				if (map[nextY][nextX] != 1 && !visited[nextY][nextX]) {

					if (i == 0) { // 가로방향
						if (curCon == 0 || curCon == 2) {
							dfs(nextX, nextY, 0);
						}
					}
					if (i == 1) { // 세로방향
						if (curCon == 1 || curCon == 2) {
							dfs(nextX, nextY, 1);
						}
					}
					if (i == 2 && checkAround(curX, curY)) { // 대각방향
						dfs(nextX, nextY, 2);
					}
				}
			}
		}

		visited[curY][curX] = false;
	}
}
