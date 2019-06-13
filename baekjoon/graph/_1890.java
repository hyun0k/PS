package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1890 { // 점프 : http://www.acmicpc.net/problem/1890

	static int n, cnt;
	static int[][] map;
	static int[] dx = { 1, 0 };
	static int[] dy = { 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();

	}

	static void bfs() {

		Queue<Node> q = new LinkedList<>();

		q.add(new Node(0, 0));
		while (!q.isEmpty()) {
			Node node = q.poll();
			int curX = node.x;
			int curY = node.y;
			int num = map[curX][curY];
			if (num == 0) {
				cnt++;
			} else {
				for (int i = 0; i < 2; i++) {
					int nextX = curX + num * dx[i];
					int nextY = curY + num * dx[i];

					if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
						continue;
					}
					q.add(new Node(nextX, nextY));
				}
			}

		}
		System.out.println(cnt);
	}

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
