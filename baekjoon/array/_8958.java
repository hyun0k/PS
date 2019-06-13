package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _8958 { // OX퀴즈 : http://www.acmicpc.net/problem/8958

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String input = br.readLine();
			int sum = 0;
			int cnt = 0;
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == 'X') {
					cnt = 0;
				} else {
					// cnt++;
					sum += ++cnt;
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

}
