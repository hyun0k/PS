package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14503 { // 로봇청소기 : http://www.acmicpc.net/problem/14503

	static int N, M, r, c, d, cnt;
	static int[][] map;
	static int[] dx = { 0, 1, 0, -1 }; // 북, 동, 남, 서
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		operate(c, r, d);

		System.out.println(cnt);
	}

	private static void operate(int curX, int curY, int dir) {

		if (map[curY][curX] == 1) {	// 벽이면 종료 
			return;
		}
		if (map[curY][curX] == 0) { 
			map[curY][curX] = 2;
			cnt++;
		}

		int turn = 0;

		for (int i = 0; i < 4; i++) {
			dir = (dir + 3) % 4;	// 현재방향의 왼쪽 
			int nextX = curX + dx[dir];
			int nextY = curY + dy[dir];

			if (map[nextY][nextX] == 0) {	
				operate(nextX, nextY, dir);
				return;		// 청소하면 다른 방향 탐색하지 않음 
			} else { // 청소할 곳이 없으면 방향전환 
				turn++;	
			}
		}

		if (turn == 4) { // 네방향 모두 청소할 곳이 없으면 
			int back = (dir + 2) % 4; // 후진 
			int backX = curX + dx[back];
			int backY = curY + dy[back];

			if (map[backY][backX] == 1) { // 벽이면 종료 
				return;
			}
			operate(backX, backY, dir);
		}

	}

}
