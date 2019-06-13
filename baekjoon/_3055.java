import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _3055 { // 탈출 : https://www.acmicpc.net/problem/3055

	static class Node {
		int x, y;
		int cost = Integer.MAX_VALUE;
		char type;

		Node(int x, int y, char type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}

	static int R, C;
	static int MAX_R = 50;
	static Node[][] map;
	static int[] dirRow = { -1, 1, 0, 0 };
	static int[] dirCol = { 0, 0, -1, 1 };
	static Queue<Node> water = new LinkedList<>();
	static Queue<Node> start = new LinkedList<>();
	static Node S, D;

	static void bfs() {
		while (!water.isEmpty()) { // 물의 이동 먼저 bfs
			Node v = water.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = v.x + dirRow[i];
				int nextY = v.y + dirCol[i];
				if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C) {
					Node next = map[nextX][nextY];
					if (next.type == '.' && next.cost == Integer.MAX_VALUE) {
						next.cost = v.cost + 1;
						water.offer(next);
					}
				}
			}
		}

		S.cost = 0;
		start.offer(S);
		while (!start.isEmpty()) { // 그 다음 고슴도치 이동 bfs
			Node v = start.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = v.x + dirRow[i];
				int nextY = v.y + dirCol[i];
				if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C) {
					Node next = map[nextX][nextY];
					if (next.cost > v.cost + 1) {
						next.cost = v.cost + 1;
						start.offer(next);
					}
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new Node[MAX_R][MAX_R];
		for (int i = 0; i < R; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				Node v = new Node(i, j, temp[j]);
				map[i][j] = v;
				if (v.type == '*') {
					v.cost = 0;
					water.offer(v);
				} else if (v.type == 'S') {
					S = v;
				} else if (v.type == 'D') {
					D = v;
				} else if (v.type == 'X') {
					v.cost = -1;
				}
			}
		}
		bfs();
		System.out.println(D.cost == Integer.MAX_VALUE ? "KAKTUS" : D.cost);
	}

}
