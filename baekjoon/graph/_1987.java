package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1987 { // 알파벳 : http://www.acmicpc.net/problem/1987

	/**
	 *   visited 배열을 2차원으로 만들 필요없음. 이전에 방문한 알파벳이 있는 지점은 모두 방문불가이기 때문에
	 *   알파벳에 대한 방문여부만 확인하면 된다. 
	 */
	
	static int R, C, step, max;
	static char[][] map;
	static boolean[] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[26];

		max = Integer.MIN_VALUE;

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		dfs(0, 0);

		System.out.println(max);
	}

	private static void dfs(int curX, int curY) {

		int curIdx = map[curY][curX] - 'A';
		visited[curIdx] = true;
		step++;

		for (int i = 0; i < 4; i++) {
			int nextX = curX + dx[i];
			int nextY = curY + dy[i];
			

			if (nextX >= 0 && nextY >= 0 && nextX < C && nextY < R) {
				int nextIdx = map[nextY][nextX] - 'A';
				
				if (!visited[nextIdx]) {
					dfs(nextX, nextY);
				}
			}
		}
		max = Math.max(max, step);

		step--;
		visited[curIdx] = false;
	}

}
