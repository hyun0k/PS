package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14888 { // 연산자 끼워넣기 : http://www.acmicpc.net/problem/14888

	static int N, max, min;
	static int[] num;
	static int[] op;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		num = new int[N];
		op = new int[4];

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}

		dfs(op[0], op[1], op[2], op[3], 1, num[0]);

		sb.append(max + "\n" + min);
		System.out.println(sb);
	}

	private static void dfs(int plus, int minus, int mul, int div, int i, int res) {

		if (i == N) {
			max = Math.max(max, res);
			min = Math.min(min, res);
			return;
		}

		if (plus != 0) {
			dfs(plus - 1, minus, mul, div, i + 1, res + num[i]);
		}
		if (minus != 0) {
			dfs(plus, minus - 1, mul, div, i + 1, res - num[i]);
		}
		if (mul != 0) {
			dfs(plus, minus, mul - 1, div, i + 1, res * num[i]);
		}
		if (div != 0) {
			dfs(plus, minus, mul, div - 1, i + 1, res / num[i]);
		}

	}

}
