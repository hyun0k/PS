package fundamental;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4344 { // 평균은 넘겠지 : http://www.acmicpc.net/problem/4344

	static int T, n;
	static int[] score;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			score = new int[n];
			for (int i = 0; i < n; i++) {
				score[i] = Integer.parseInt(st.nextToken());
			}

			int sum = 0;
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				sum += score[i];
			}

			double mean = sum / n;
			for (int i = 0; i < n; i++) {
				if (score[i] > mean) {
					cnt++;
				}
			}
			
			sb.append(String.format("%.3f%%%n", (double)cnt / (double)n * 100));

		}
		System.out.println(sb);
	}

}
