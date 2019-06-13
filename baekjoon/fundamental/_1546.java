package fundamental;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1546 { // 평균 : http://www.acmicpc.net/problem/1546

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] score = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(score);
		double M = score[n - 1];

		double sum = 0;
		for (int i = 0; i < n; i++) {
			sum += score[i];
		}
		double m = (100 / M) * (sum / n);

		System.out.println(m);
	}

}
