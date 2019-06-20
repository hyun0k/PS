package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _2583 { // 영역 구하기 : http://www.acmicpc.net/problem/2583
	/**
	 *  단지번호 붙이기와 거의 유사한 문제. 단지번호 붙이기는 map을 input으로 받았지만 이 문제는
	 *  좌표를 입력받아 map을 그려야한다는 차이점이 있음. x, y 순서 주의할것. 
	 */
	static int M, N, K, cnt;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Point> pointList = new ArrayList<>();
	static ArrayList<Integer> area = new ArrayList<>();
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			pointList.add(new Point(x1, y1, x2, y2));
		}

		for (int i = 0; i < pointList.size(); i++) {
			Point p = pointList.get(i);
			for (int j = p.y1; j < p.y2; j++) {
				for (int k = p.x1; k < p.x2; k++) {
					if (map[j][k] == 0) {
						map[j][k] = 1;	// 벽을 1로 표시. 
					}
				}
			}
		}

		go(0, 0);

		Collections.sort(area);
		sb.append(area.size() + "\n");
		for (int i : area) {
			sb.append(i + " ");
		}
		System.out.println(sb);

	}

	private static void go(int x, int y) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					dfs(j, i);
					area.add(cnt);
					cnt = 0;
				}
			}
		}
	}

	private static void dfs(int x, int y) {
		if (map[y][x] == 1 || visited[y][x]) {
			return;
		}
		visited[y][x] = true;
		cnt++;
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
				continue;
			}
			if (visited[nextY][nextX] || map[nextY][nextX] == 1) {
				continue;
			}
			dfs(nextX, nextY);
		}
	}

	private static class Point {
		int x1, y1, x2, y2;

		Point(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
}
