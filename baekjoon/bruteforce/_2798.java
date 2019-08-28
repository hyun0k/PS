package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2798 { // 블랙잭 : http://www.acmicpc.net/problem/2798

	static int N, M, max;
	static int[] card;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		card = new int[N];

		max = Integer.MIN_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0, 0);

		System.out.println(max);

	}

	private static void dfs(int idx, int cnt, int res) {

		if (cnt == 3 && res <= M) {
			max = Math.max(max, res);
			return;
		}

		if (res > M || idx >= N) {
			return;
		}

		dfs(idx + 1, cnt + 1, res + card[idx]); // 현재 카드 선택 
		dfs(idx + 1, cnt, res); // 현재 카드 선택 X 

	}
}
