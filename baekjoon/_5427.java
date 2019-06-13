import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5427 { // 불 : https://www.acmicpc.net/problem/5427

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

	static int test_case, W, H, cnt;
	static int MAX = 1000;
	static Node S;
	static Node[][] map = new Node[MAX][MAX];
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static Queue<Node> fire = new LinkedList<>();
	static Queue<Node> start = new LinkedList<>();

	static void bfs() {
		cnt = 0;
		while (!fire.isEmpty()) { // 불 먼저 이동 bfs 
			Node v = fire.poll();
			for (int[] i : dir) {
				int nextX = v.x + i[0];
				int nextY = v.y + i[1];
				if (nextX >= 0 && nextX < H && nextY >= 0 && nextY < W) {
					Node next = map[nextX][nextY];
					if (next.type == '.' && next.cost == Integer.MAX_VALUE) {
						next.type = '*';
						next.cost = v.cost + 1;
						fire.offer(next);
					}
				}
			}
		}

		while (!start.isEmpty()) { // 그 다음 상근이 출발 bfs
			Node v = start.poll();
			for (int[] i : dir) {
				int nextX = v.x + i[0];
				int nextY = v.y + i[1];
				if (nextX < 0 || nextX >= H || nextY < 0 || nextY >= W) {
					cnt = ++v.cost;
					break;
				}

				Node next = map[nextX][nextY];
				if (next.cost > v.cost + 1) {
					next.cost = v.cost + 1;
					start.offer(next);
				}

			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		test_case = Integer.parseInt(br.readLine());

		for (int t = 0; t < test_case; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			for (int i = 0; i < H; i++) {
				char[] temp = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					Node v = new Node(i, j, temp[j]);
					map[i][j] = v;
					if (v.type == '*') {
						v.cost = 0;
						fire.offer(v);
					} else if (v.type == '@') {
						v.cost = 0;
						start.offer(v);
					} else if (v.type == '#') {
						v.cost = -1;
					}
				}
			}
			bfs();
			System.out.println(cnt == 0 ? "IMPOSSIBLE" : cnt);
		}

	}

}
