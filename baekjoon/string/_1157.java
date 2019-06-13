package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1157 { // http:// 단어 공부 : http://www.acmicpc.net/problem/1157

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = (br.readLine()).toUpperCase();
		int[] arr = new int[26];

		for (int i = 0; i < input.length(); i++) {
			int idx = input.charAt(i) - 'A';
			arr[idx]++;
		}

		int max = -1;
		char ans = '?';
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				ans = (char) (i + 65);
			} else if (max == arr[i]) {
				ans = '?';
			}
		}
		System.out.println(ans);
	}

}
