/**
 * 
 */
package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Project : codePlus
 * @Package : graph
 * @FileName : _7576.java
 * @Author : hyunyoungkim
 * @Date : Feb 15, 2019
 */
public class _7576 { // 토마토 : http://www.acmicpc.net/problem/7576

	/**
	 * @param args
	 */
	static int m, n, cnt;
	static int[][] map, day;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		day = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();

	}

	static void bfs() {

		Queue<Node> q = new LinkedList<>();
		
		// 익은 토마토의 좌표를 큐에 삽입 (동시에 일어나므로)
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					q.add(new Node(i, j));
				}
			}
		}

		while (!q.isEmpty()) {
			Node node = q.poll();
			int curX = node.x;
			int curY = node.y;
			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				// 범위 밖이거나 인접한 토마토가 이미 익은 토마토면 pass 
				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m || map[nextX][nextY] != 0) {
					continue;
				}

				map[nextX][nextY] = 1;
				day[nextX][nextY] = day[curX][curY] + 1;

				q.add(new Node(nextX, nextY));
			}
		}
		
		// day에서 최댓값찾기 
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				max = Math.max(max, day[i][j]);
			}
		}
		System.out.println(max);
	}

	// 좌표를 나타낼 node클래스 생성 
	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
