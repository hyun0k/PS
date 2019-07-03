package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _3055 { // 탈출 : http://www.acmicpc.net/problem/3055

	/**
	 *  돌은 신경쓰지 않는다. 물 먼저 채우고 그 다음 고슴도치가 이동한다. 
	 */
	
	static int R, C, ans;
	static char[][] map;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static Queue<Point> water = new LinkedList<>();
	static Queue<Point> start = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

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

		ans = 0;
		while (true) {
			++ans;
			if (start.size() == 0) {
				System.out.println("KAKTUS");
				return;
			}

			flooding();
			if (moveHedge()) {
				System.out.println(ans);
				return;
			}
		}

	}

	private static void flooding() {
		int size = water.size();
		for (int j = 0; j < size; j++) {
			Point p = water.poll();
			int curX = p.x;
			int curY = p.y;

			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];

				if (nextX >= 0 && nextY >= 0 && nextX < C && nextY < R) {
					if (map[nextY][nextX] == '.') {
						map[nextY][nextX] = '*';
						water.add(new Point(nextX, nextY));
					}
				}
			}
		}
	}

	private static boolean moveHedge() {
		int size = start.size();
		for (int j = 0; j < size; j++) {
			Point p = start.poll();
			int curX = p.x;
			int curY = p.y;

			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];

				if (nextX >= 0 && nextY >= 0 && nextX < C && nextY < R) {
					if (map[nextY][nextX] == 'D') {
						start.add(new Point(nextX, nextY));
						return true;
					}
					if (map[nextY][nextX] == '.') {
						map[nextY][nextX] = 'S';
						start.add(new Point(nextX, nextY));
					}
				}
			}
		}
		return false;
	}

	private static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
