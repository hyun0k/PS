package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2206 { // 벽 부수고 이동하기 : http://www.acmicpc.net/problem/2206

	static int N, M, step;
	static boolean flag;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static Queue<Point> q;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M][2];
		flag = false;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs(0, 0, 0);

		System.out.println(flag ? step : -1);
	}

	private static void bfs(int x, int y, int c) {

		q = new LinkedList<>();
		q.add(new Point(x, y, c));
		visited[y][x][0] = true; // 벽을 안부수는 경우 
		visited[y][x][1] = true; // 벽을 부수는 경우 

		step = 0;
		
		while (!q.isEmpty() && !flag) {
			step++;

			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				int curX = p.x;
				int curY = p.y;
				int curC = p.c;

				if (curX == M - 1 && curY == N - 1) { // 도착. 
					flag = true;
					break;
				}

				for (int j = 0; j < 4; j++) {
					int nextX = curX + dx[j];
					int nextY = curY + dy[j];

					if (nextX >= 0 && nextY >= 0 && nextX < M && nextY < N) {
						
						if (map[nextY][nextX] == 1) { // 벽 일때
							if (curC == 0 && !visited[nextY][nextX][1]) {
								visited[nextY][nextX][1] = true;
								q.add(new Point(nextX, nextY, 1));
							}
						}
						if (map[nextY][nextX] == 0) { // 벽이 아닐때
							if (!visited[nextY][nextX][curC]) {
								visited[nextY][nextX][curC] = true;
								q.add(new Point(nextX, nextY, curC));
							}
						}
					}
				}
			}

		}
	}

	private static class Point {
		int x, y, c;

		Point(int x, int y, int c) { // c: 벽을 부순 개수  
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

}
