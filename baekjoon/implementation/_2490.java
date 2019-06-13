package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2490 { // 윷놀이 : http://www.acmicpc.net/problem/2490

	static int[] a = new int[4];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < a.length; j++) {
				a[j] = Integer.parseInt(st.nextToken());
			}

			int cnt = 0;
			for (int j = 0; j < a.length; j++) {
				if (a[j] == 0) {
					cnt++;
				}
			}

			switch (cnt) {
			case 0:
				sb.append("E").append(System.lineSeparator());
				break;
			case 1:
				sb.append("A").append(System.lineSeparator());
				break;
			case 2:
				sb.append("B").append(System.lineSeparator());
				break;
			case 3:
				sb.append("C").append(System.lineSeparator());
				break;
			case 4:
				sb.append("D").append(System.lineSeparator());
				break;
			}
		}
		System.out.println(sb);

	}

}
