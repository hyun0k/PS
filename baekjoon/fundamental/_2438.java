package fundamental;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2438 { // 별찍기-1 : http://www.acmicpc.net/problem/2438

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}
