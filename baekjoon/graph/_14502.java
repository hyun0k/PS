package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _14502 { // 연구소 : http://www.acmicpc.net/problem/14502

	static int N, M, ans;
	static int[][] map;
	static int[][] tempMap;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		tempMap = new int[N][M];

		ans = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		buildWall(0, 0);

		System.out.println(ans);

	}

	private static void copyMap(int[][] origin, int[][] copied) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copied[i][j] = origin[i][j];
			}
		}
	}

	private static void buildWall(int start, int cnt) {

		if (cnt == 3) { // 벽이 3개 세워지면 tempMap에 복사하고 바이러스 퍼뜨림.
			copyMap(map, tempMap);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (tempMap[i][j] == 2) {
						spreadVirus(i, j);
					}
				}
			}

			ans = Math.max(ans, getSafetyArea(tempMap));
			return;
		}

		for (int i = start; i < N * M; i++) { // 벽세우기.
			int x = i / M;
			int y = i % M;
			if (map[x][y] == 0) {
				map[x][y] = 1;
				buildWall(i + 1, cnt + 1);
				map[x][y] = 0;
			}
		}
	}

	private static void spreadVirus(int x, int y) { // 바이러스 퍼뜨리기.

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
				continue;
			}
			if (tempMap[nextX][nextY] == 0) {
				tempMap[nextX][nextY] = 2;
				spreadVirus(nextX, nextY);
			}
		}
	}

	private static int getSafetyArea(int[][] arr) { // 안전영역 카운트.
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

}
