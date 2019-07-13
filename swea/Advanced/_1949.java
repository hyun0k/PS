package Advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1949 { // 등산로 조성
	/**
	 * dfs + 완전탐색
	 */

	static int T, N, K, highest, length, max;
	static int[][] map;
	static boolean flag;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static ArrayList<Point> peak;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			visited = new boolean[N][N];
			peak = new ArrayList<>();

			max = Integer.MIN_VALUE;
			highest = Integer.MIN_VALUE;
			flag = false;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					highest = Math.max(highest, map[i][j]);
				}
			}

			for (int i = 0; i < N; i++) { // 봉우리 찾기
				for (int j = 0; j < N; j++) {
					if (map[i][j] == highest) {
						peak.add(new Point(j, i));
					}
				}
			}

			explore();

			sb.append("#" + tc + " " + max + "\n");
		}
		System.out.println(sb);
	}

	private static void explore() {

		int size = peak.size();
		for (int i = 0; i < size; i++) {
			Point p = peak.get(i);
			dfs(p.x, p.y);
			
			// 초기화 
			length = 0;       
			flag = false;
		}
	}

	private static void dfs(int curX, int curY) {

		visited[curY][curX] = true;
		length++;

		for (int i = 0; i < 4; i++) {
			int nextX = curX + dx[i];
			int nextY = curY + dy[i];

			if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {

				if (flag) { // 깎기 이미 한 경우.

					if (map[nextY][nextX] < map[curY][curX] && !visited[nextY][nextX]) { // 내리막인 경우 
						dfs(nextX, nextY);
					}

				} else { // 아직 안 깎은 경우.

					if (map[nextY][nextX] < map[curY][curX] && !visited[nextY][nextX]) { // 내리막인 경우 
						dfs(nextX, nextY);
					}

					if (map[nextY][nextX] >= map[curY][curX] && !visited[nextY][nextX]) { // 오르막인 경우 
						for (int depth = 1; depth <= K; depth++) { // 1씩 깎아본다 
							if (map[nextY][nextX] - depth < map[curY][curX]) {
								map[nextY][nextX] -= depth;
								flag = true;
								dfs(nextX, nextY);
								// 원래대로 만들기 
								map[nextY][nextX] += depth;
								flag = false;
							}
						}
					}
				}

			}
		}
		max = Math.max(max, length);
		// 원래대로 만들기 
		length--;
		visited[curY][curX] = false;
	}

	private static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
