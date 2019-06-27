package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4963 { // 섬의 개수 : http://www.acmicpc.net/problem/4963
	/**
	 * 단지번호 붙이기와 거의 같은 문제. 다른 점은 이 문제에서는 대각선 방향에 인접한것도 연결된 것으로
	 * 본다는 점이다. 단순히 탐색할때 4방향을 하던것을 8방향으로 해주면 된다. 
	 */
	static int H, W, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static int[] dy = { 1, -1, 0, 0, 1, 1, -1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			if (W == 0 && H == 0) {
				break;
			}

			map = new int[H][W];
			visited = new boolean[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			cnt = 0;
			explore();
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}

	private static void explore() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					dfs(j, i);
					cnt++;
				}
			}
		}
	}

	private static void dfs(int x, int y) {
		for (int i = 0; i < 8; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if (nextX < 0 || nextY < 0 || nextX >= W || nextY >= H) {
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
