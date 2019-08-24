package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15649 { // N과 M (1) : http://www.acmicpc.net/problem/15649

	/**
	 * 1부터 N까지 중복없이 M개를 고른 수열
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
		arr = new int[M];
		visited = new boolean[N];

		dfs(0);

		System.out.println(sb);
	}

	private static void dfs(int m) {

		if (m == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[m] = i + 1;
				dfs(m + 1);
				visited[i] = false;
			}
		}

	}
}
