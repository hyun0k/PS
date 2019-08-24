package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15651 { // N과 M (3) : http://www.acmicpc.net/problem/15651
	
	/**
	 *  중복허용 
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

			arr[m] = i + 1;
			dfs(m + 1);

		}
	}

}
