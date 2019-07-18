package Advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1953 { // 탈주범 검거

	/**
	 *  상하좌우 방향을 잘 생각할것. y좌표 + 가 아래 방향이고 y좌표 - 가 위로 가는 방향이다. 
	 */
	static int T, N, M, R, C, L, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static Queue<Point> q;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visited = new boolean[N][M];
			q = new LinkedList<>();

			cnt = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j]) {
						cnt++;
					}
				}
			}

			sb.append("#" + tc + " " + cnt + "\n");
		}
		System.out.println(sb);
	}

	private static void bfs() {

		visited[R][C] = true;
		q.add(new Point(C, R));

		int time = 0;
		while (true) {
			time++;
			if (time == L) {				
				break;
			}

			int size = q.size();
			for (int j = 0; j < size; j++) {
				Point p = q.poll();
				int curX = p.x;
				int curY = p.y;
				int curPipe = map[curY][curX];

				for (int i = 0; i < 4; i++) { // 0:하 1:상 2:우 3:좌
					if (curPipe == 2 && (i == 2 || i == 3))         // 각 파이프마다 막혀있는 방향은 탐색 X
						continue;
					else if (curPipe == 3 && (i == 0 || i == 1))
						continue;
					else if (curPipe == 4 && (i == 0 || i == 3))
						continue;
					else if (curPipe == 5 && (i == 1 || i == 3))
						continue;
					else if (curPipe == 6 && (i == 1 || i == 2))
						continue;
					else if (curPipe == 7 && (i == 0 || i == 2))
						continue;

					int nextX = curX + dx[i];
					int nextY = curY + dy[i];

					if (nextX >= 0 && nextY >= 0 && nextX < M && nextY < N) {
						int nextPipe = map[nextY][nextX];

						if (nextPipe != 0 && !visited[nextY][nextX]) {

							// 각 방향마다 터널이 연결되어 있으면 방문하고 q에 삽입 
							if (i == 0) { // 하 
								if (nextPipe == 1 || nextPipe == 2 || nextPipe == 4 || nextPipe == 7) {
									visited[nextY][nextX] = true;
									q.add(new Point(nextX, nextY));
								}
							} else if (i == 1) { // 상 
								if (nextPipe == 1 || nextPipe == 2 || nextPipe == 5 || nextPipe == 6) {
									visited[nextY][nextX] = true;
									q.add(new Point(nextX, nextY));
								}
							} else if (i == 2) { // 우 
								if (nextPipe == 1 || nextPipe == 3 || nextPipe == 6 || nextPipe == 7) {
									visited[nextY][nextX] = true;
									q.add(new Point(nextX, nextY));
								}
							} else if (i == 3) { // 좌 
								if (nextPipe == 1 || nextPipe == 3 || nextPipe == 4 || nextPipe == 5) {
									visited[nextY][nextX] = true;
									q.add(new Point(nextX, nextY));
								}
							}
						}
					}
				}
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
