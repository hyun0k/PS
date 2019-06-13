package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2577 { // 숫자의 개수 : http://www.acmicpc.net/problem/2577

	static int[] numCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		String res = Integer.toString(a * b * c);

		numCnt = new int[10];
		for (int i = 0; i < res.length(); i++) {
			int idx = res.charAt(i) - '0';
			numCnt[idx]++;
		}

		for (int i = 0; i < numCnt.length; i++) {
			sb.append(numCnt[i]).append("\n");
		}

		System.out.println(sb);

	}

}
