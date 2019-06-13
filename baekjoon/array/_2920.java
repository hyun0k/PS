package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2920 { // 음계 : http://www.acmicpc.net/problem/2920

	static int[] arr = new int[8];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		String res = "";
		for (int i = 0; i < 7; i++) {
			if (arr[i] == arr[i + 1] - 1) {
				res = "ascending";
			} else if (arr[i] == arr[i + 1] + 1) {
				res = "descending";
			} else {
				res = "mixed";
				break;
			}
		}
		System.out.println(res);

	}

}
