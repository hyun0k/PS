package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2675 { // 문자열 반복 : http://www.acmicpc.net/problem/2675

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int rep = Integer.parseInt(st.nextToken());
			String input = st.nextToken();

			for (int i = 0; i < input.length(); i++) {
				for (int j = 0; j < rep; j++) {
					sb.append(input.charAt(i));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
