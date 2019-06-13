import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class _2667 { // 단지번호 붙이기 : https://www.acmicpc.net/problem/2667

	static int N, cnt;
	static int[][] map;
	static boolean[][] visited = new boolean[27][27];
	static int[] dirRow = { -1, 1, 0, 0 };
	static int[] dirCol = { 0, 0, -1, 1 };
	static ArrayList<Integer> complex;

	static void go(int x, int y) { // (1,1)부터 map순회하다가 1만나면 dfs

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					dfs(i, j);
					complex.add(cnt);
					cnt = 0;
				}

			}
		}

	}

	static void dfs(int x, int y) {
		if (map[x][y] == 0 || visited[x][y]) {
			return;
		}
		visited[x][y] = true;
		cnt++;
		for (int i = 0; i < 4; i++) {
			int row = x + dirRow[i];
			int col = y + dirCol[i];
			if (map[row][col] == 0) {
				continue;
			} else if (visited[row][col]) {
				continue;
			}
			dfs(row, col);
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		complex = new ArrayList<>();

		map = new int[N + 2][N + 2];
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= N; j++) {
				map[i][j] = str.charAt(j - 1) - '0';
			}
		}

		go(1, 1);
		sb.append(complex.size());
		sb.append('\n');
		Collections.sort(complex); // ArrayList 오름차순 정렬
		for (Integer i : complex) {
			sb.append(i);
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

}
