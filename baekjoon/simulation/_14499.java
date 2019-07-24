package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14499 { // 주사위 굴리기 : http://www.acmicpc.net/problem/14499

	static int N, M, R, C, K;
	static int[][] map;
	static int[] dice = { 0, 0, 0, 0, 0, 0 }; // 상단, 위쪽, 오른쪽, 왼쪽, 아래쪽, 하단
	static int[] dx = { 1, -1, 0, 0 };// 동, 서, 북, 남
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		int curX = C;
		int curY = R;

		while (K-- > 0) {
			int dir = Integer.parseInt(st.nextToken());

			int nextX = curX + dx[dir - 1];
			int nextY = curY + dy[dir - 1];

			if (nextX >= 0 && nextY >= 0 && nextX < M && nextY < N) {

				rollDice(dir);

				if (map[nextY][nextX] != 0) {
					dice[5] = map[nextY][nextX];
					map[nextY][nextX] = 0;
				} else {
					map[nextY][nextX] = dice[5];
				}

				sb.append(dice[0] + "\n");

				curX = nextX;
				curY = nextY;
			}
		}
		System.out.println(sb);

	}

	private static void rollDice(int k) { // 1:동, 2:서, 3:북, 4:남

		int[] temp = new int[6];
		for (int i = 0; i < 6; i++) {
			temp[i] = dice[i];
		}

		if (k == 1) {
			dice[0] = temp[3];
			dice[2] = temp[0];
			dice[3] = temp[5];
			dice[5] = temp[2];
		} else if (k == 2) {
			dice[0] = temp[2];
			dice[2] = temp[5];
			dice[3] = temp[0];
			dice[5] = temp[3];
		} else if (k == 3) {
			dice[0] = temp[4];
			dice[1] = temp[0];
			dice[4] = temp[5];
			dice[5] = temp[1];
		} else if (k == 4) {
			dice[0] = temp[1];
			dice[1] = temp[5];
			dice[4] = temp[0];
			dice[5] = temp[4];
		}
	}
}
