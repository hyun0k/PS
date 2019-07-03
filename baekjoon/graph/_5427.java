package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5427 { // 불 : http://www.acmicpc.net/problem/5427
	
	/**
	 *  불이 먼저 번지고 상근이가 이동한다. 한 스텝씩 bfs수행. 벽(#)은 신경쓰지 않는다. 
	 */

	static int T, W, H, step;
	static boolean flag;
	static char[][] map;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static Queue<Point> fire; 
	static Queue<Point> start; 

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new char[H][W];
			step = 0;
			flag = false;

			fire = new LinkedList<>();
			start = new LinkedList<>();
			
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);

					if (map[i][j] == '*') {
						fire.add(new Point(j, i));
					}
					if (map[i][j] == '@') {
						start.add(new Point(j, i));
					}
				}
			}

			spreadFire();

			if (flag) {
				sb.append(step + "\n");
			} else {
				sb.append("IMPOSSIBLE" + "\n");
			}
		}
		System.out.println(sb);
	}

	private static void spreadFire() {

		while (!fire.isEmpty() || !start.isEmpty()) {
			
			int fsize = fire.size();
			for (int i = 0; i < fsize; i++) { // 불 먼저 bfs. 현재 칸의 상하좌우만 탐색. 큐에 다음 칸이 들어있지만 상근이 이동후에 다시 bfs 수행. 
				Point p = fire.poll();
				int curX = p.x;
				int curY = p.y;

				for (int j = 0; j < 4; j++) {
					int nextX = curX + dx[j];
					int nextY = curY + dy[j];

					if (nextX >= 0 && nextY >= 0 && nextX < W && nextY < H) {
						if (map[nextY][nextX] == '.' || map[nextY][nextX] == '@') {
							map[nextY][nextX] = '*';
							fire.add(new Point(nextX, nextY));
						}
					}
				}
			}

			int ssize = start.size();
			if (ssize > 0) {
				step++;

				for (int i = 0; i < ssize; i++) { // 상근이 이동 bfs. 
					Point p = start.poll();
					int curX = p.x;
					int curY = p.y;

					for (int j = 0; j < 4; j++) {
						int nextX = curX + dx[j];
						int nextY = curY + dy[j];

						if (nextX < 0 || nextY < 0 || nextX >= W || nextY >= H) {
							flag = true;
							return;
						}
						if (map[nextY][nextX] == '.') {
							map[nextY][nextX] = '@';
							start.add(new Point(nextX, nextY));
						}

					}
				}
			} else {
				return;
			}
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
