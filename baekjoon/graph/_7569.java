package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7569 { // 토마토2 : http://www.acmicpc.net/problem/7569
	/**
	 * 토마토 문제에서 Z축으로 확장된 형태의 문제이다. 
	 */
	static int m, n, h, cnt;
	static int[][][] map, day;
	static int[] dx = { 1, -1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, 1, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		map = new int[h][n][m];
		day = new int[h][n][m];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		bfs();

	}

	static void bfs() {

		Queue<Node> q = new LinkedList<>();

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[i][j][k] == 1) {
						q.add(new Node(j, k, i));
					}
				}
			}
		}

		while (!q.isEmpty()) {
			Node node = q.poll();
			int curX = node.x;
			int curY = node.y;
			int curZ = node.z;
			for (int i = 0; i < 6; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				int nextZ = curZ + dz[i];
				if (nextX < 0 || nextY < 0 || nextZ < 0 || nextX >= n || nextY >= m || nextZ >= h
						|| map[nextZ][nextX][nextY] != 0) {
					continue;
				}
				map[nextZ][nextX][nextY] = 1;
				day[nextZ][nextX][nextY] = day[curZ][curX][curY] + 1;

				q.add(new Node(nextX, nextY, nextZ));
			}
		}

		int max = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
					max = Math.max(max, day[i][j][k]);
				}
			}
		}
		System.out.println(max);
	}

	static class Node {
		int x;
		int y;
		int z;

		Node(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
