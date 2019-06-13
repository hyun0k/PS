package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _10871 { // X보다 작은 수 : http://www.acmicpc.net/problem/10871

	static int n, x;
	static int[] a;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		a = new int[n];

		// 배열에 수열 저장
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		// 출력
		for (int i = 0; i < n; i++) {
			if (a[i] < x) {
				sb.append(a[i]).append(" ");
			}
		}

		System.out.println(sb);

	}

}
