package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _3055 { // 탈출 : http://www.acmicpc.net/problem/3055

	/**
	 * 돌은 신경쓰지 않는다. 물 먼저 채우고 그 다음 고슴도치가 이동한다.
	 */

	static int R, C, step;
	static boolean flag;
	static char[][] map;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static Queue<Point> water;
	static Queue<Point> start;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		step = 0;
		flag = false;

		water = new LinkedList<>();
		start = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '*') {
					water.add(new Point(j, i));
				}

				if (map[i][j] == 'S') {
					start.add(new Point(j, i));
				}
			}
		}

		flooding();

		System.out.println(flag ? step : "KAKTUS");
	}

	private static void flooding() {

		while (!water.isEmpty() || !start.isEmpty()) {

			int wsize = water.size();
			for (int i = 0; i < wsize; i++) {	// 물 먼저 이동. 
				Point p = water.poll();
				int curX = p.x;
				int curY = p.y;

				for (int j = 0; j < 4; j++) {
					int nextX = curX + dx[j];
					int nextY = curY + dy[j];

					if (nextX >= 0 && nextY >= 0 && nextX < C && nextY < R) {
						if (map[nextY][nextX] == '.' || map[nextY][nextX] == 'S') {
							map[nextY][nextX] = '*';
							water.add(new Point(nextX, nextY));
						}
					}
				}
			}
			
			int ssize = start.size();
			if (ssize > 0) {
				step++;

				for (int i = 0; i < ssize; i++) { // 고슴도치 이동. 
					Point p = start.poll();
					int curX = p.x;
					int curY = p.y;

					for (int j = 0; j < 4; j++) {
						int nextX = curX + dx[j];
						int nextY = curY + dy[j];

						if (nextX >= 0 && nextY >= 0 && nextX < C && nextY < R) {
							if (map[nextY][nextX] == 'D') {
								flag = true;
								return;
							}
							if (map[nextY][nextX] == '.') {
								map[nextY][nextX] = 'S';
								start.add(new Point(nextX, nextY));
							}
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
