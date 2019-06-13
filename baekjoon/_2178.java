import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2178 { // 미로 탐색 : https://www.acmicpc.net/problem/2178

	static class Node {
		int x, y, step;
		Node(int x, int y, int step) {
			this.x = x;
			this.y = y;
			this.step = step;
		}
	}

	static int N, M, res;
	static int[][] map;
	static int[] dirRow = { 0, 0, -1, 1 };
	static int[] dirCol = { -1, 1, 0, 0 };

	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y, 1));
		while (!q.isEmpty()) {
			Node v = q.poll();
			int step = v.step;
			if (v.x == N && v.y == M) {
				res = v.step;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int row = v.x + dirRow[i];
				int col = v.y + dirCol[i];
				if (map[row][col] == 0) {
					continue;
				} else if (map[row][col] == 1) {
					map[row][col] = step + 1;
					q.offer(new Node(row, col, step + 1));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 2][M + 2];
		for (int i = 1; i <= N; i++) {
			String str = br.readLine(); // 입력이 붙어서 주어지므로 stringtokenizer 사용불가 
			for (int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j - 1) - '0';
			}
		}
		bfs(1, 1);
		System.out.println(res);
	}

}
