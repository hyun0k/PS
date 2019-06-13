package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1427 { // 소트인사이드 : http://www.acmicpc.net/problem/1427

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String num = br.readLine();
		int[] arr = new int[num.length()];

		for (int i = 0; i < num.length(); i++) {
			arr[i] = num.charAt(i) - '0';
		}

		Arrays.sort(arr);

		for (int i = arr.length - 1; i >= 0; i--) {
			sb.append(arr[i]);
		}

		System.out.println(sb);

	}

}
