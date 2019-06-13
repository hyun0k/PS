package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _10610 { // 30 : http://www.acmicpc.net/problem/10610

	/**
	 *  3의 배수이면서 10의 배수가 되는 가장 큰 수를 만든다.
	 *  각자리수의 합이 3의 배수가 되고 0을 하나라도 포함하면 30의 배수를 만들수 있다. 
	 */
	static String N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = br.readLine();
		arr = new int[N.length()];

		int sum = 0;
		for (int i = 0; i < N.length(); i++) {
			arr[i] = N.charAt(i) - '0';
			sum += arr[i];
		}

		if (sum % 3 == 0) {
			Arrays.sort(arr);
			if (arr[0] == 0) {
				for (int i = arr.length - 1; i >= 0; i--) {
					sb.append(arr[i]);
				}
			} else {
				sb.append(-1);
			}
		} else {
			sb.append(-1);
		}
		System.out.println(sb);
	}

}
