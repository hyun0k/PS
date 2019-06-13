package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2231 { // 분해합 : http://www.acmicpc.net/problem/2231

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		int ans = 0;
		boolean check = false;

		int cnt = 0;
		int nn = N;
		while (nn != 0) {
			nn /= 10;
			cnt++;
		}

		// 1부터 모두 조사하지 않고 각 자리수의 최댓값이 9이므로 [N-9*자릿수, N] 구간만 조사해도된다. 
		for (int i = N - (9 * cnt); i < N; i++) {
			int sum = 0;
			int num = i;
			String str = Integer.toString(num);
			for (int j = 0; j < str.length(); j++) {
				sum += str.charAt(j) - '0';
			}
			sum += num;
			if (sum == N) {
				ans = num;
				check = true;
				break;
			}
		}

		if (check) {
			System.out.println(ans);
		} else {
			System.out.println(0);
		}
	}

}
