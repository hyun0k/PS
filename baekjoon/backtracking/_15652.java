package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15652 { // N과 M (4) : http://www.acmicpc.net/problem/15652
	/**
	 *  중복허용. 비내림차순 수열만 출력
	 */
	static int N, M;
	static int[] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		sb = new StringBuilder();

		arr = new int[M];

		dfs(0, -1);

		System.out.println(sb);
	}

	private static void dfs(int m, int pre) { // pre : 이전 값

		if (m == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (i >= pre) {

				arr[m] = i + 1;
				dfs(m + 1, i);

			}
		}
	}

}
