package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6603 { // 로또 : http://www.acmicpc.net/problem/6603

	static int k;
	static int[] num;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());

			k = Integer.parseInt(st.nextToken());

			if (k == 0) {
				break;
			}

			num = new int[k];
			visited = new boolean[k];

			sb = new StringBuilder();

			for (int i = 0; i < k; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 0);

			System.out.println(sb);
		}

	}

	private static void printArray() {

		for (int i = 0; i < k; i++) {
			if (visited[i]) {
				sb.append(num[i] + " ");
			}
		}
		sb.append("\n");
	}

	private static void dfs(int idx, int cnt) {

		if (cnt == 6) {
			printArray();
			return;
		}

		for (int i = idx; i < k; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i + 1, cnt + 1);
				visited[i] = false;
			}
		}

	}

}
