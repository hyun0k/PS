package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2217 { // 로프 : http://www.acmicpc.net/problem/2217

	static int N;
	static int[] rope;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		rope = new int[N];

		for (int i = 0; i < N; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(rope);

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, rope[i] * (N - i));
		}
		System.out.println(max);
	}

}
