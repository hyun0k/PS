package Advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2105 { // 디저트 카페

	/**
	 *  dfs + 완전탐색. 그런데 탐색할때 반복문으로 돌지않는다. 
	 */
	
	static int T, N, startX, startY, max, ans;
	static int[][] map;
	static boolean[][] visited;
	static boolean[] dessert;
	static int[] dx = { 1, -1, -1, 1 };
	static int[] dy = { -1, -1, 1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			visited = new boolean[N][N];
			dessert = new boolean[101];

			max = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			explore();

			ans = (max == Integer.MIN_VALUE) ? -1 : max;

			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}

	private static void explore() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				startX = j;
				startY = i;
				visited[i][j] = true;
				dessert[map[i][j]] = true;
				
				dfs(j, i, 0, 0);
				// 초기화 
				visited[i][j] = false;
				dessert[map[i][j]] = false;
			}
		}
	}

	private static void dfs(int curX, int curY, int dir, int cnt) {

		if (dir == 4) {
			return;
		}

		int nextX = curX + dx[dir];
		int nextY = curY + dy[dir];

		if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
			return;
		}

		int nextIdx = map[nextY][nextX];

		if (visited[nextY][nextX] || dessert[nextIdx]) {
			if (nextX == startX && nextY == startY) {
				max = Math.max(max, cnt + 1);
			}
			return;
		}

		visited[nextY][nextX] = true;
		dessert[nextIdx] = true;

		dfs(nextX, nextY, dir, cnt + 1); // 방향 전환하지 않고 계속 탐색 
		dfs(nextX, nextY, dir + 1, cnt + 1); // 방향 전환하고 계속 탐색 
		// 초기화 
		visited[nextY][nextX] = false;
		dessert[nextIdx] = false;

	}

}
