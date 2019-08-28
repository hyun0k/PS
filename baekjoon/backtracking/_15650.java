package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15650 { // N과 M (2) : http://www.acmicpc.net/problem/15650
	/**
	 * 오름차순 수열만 출력
	 */
	static int N, M;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		sb = new StringBuilder();
		visited = new boolean[N];

		dfs(0, 0);

		System.out.println(sb);
	}

	private static void printArray() {

		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				sb.append((i + 1) + " ");
			}
		}
		sb.append("\n");
	}

	private static void dfs(int pre, int cnt) { // pre : 이전 값

		if (cnt == M) {
			printArray();
			return;
		}

		for (int i = pre; i < N; i++) {
			if (!visited[i]) { 
				visited[i] = true;
				dfs(i + 1, cnt + 1);
				visited[i] = false;
			}
		}
	}

}
