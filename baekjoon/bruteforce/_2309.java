package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2309 { // 일곱 난쟁이 : http://www.acmicpc.net/problem/2309

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] arr = new int[9];

		int sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}

		boolean check = false;
		for (int i = 0; i < 9; i++) {
			if (check) {
				break;
			}
			for (int j = i + 1; j < 9; j++) {
				if (sum - arr[i] - arr[j] == 100) {
					arr[i] = 0;
					arr[j] = 0;
					check = true;
					break;
				}
			}
		}

		Arrays.sort(arr);
		for (int i = 2; i < arr.length; i++) {
			sb.append(arr[i] + "\n");
		}

		System.out.println(sb);

	}

}
