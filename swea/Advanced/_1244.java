package Advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1244 { // 최대 상금

	static int T, k, ans;
	static String n;
	static int[] numArr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = st.nextToken();
			k = Integer.parseInt(st.nextToken());
			numArr = new int[n.length()];

			for (int i = 0; i < n.length(); i++) {
				numArr[i] = n.charAt(i) - '0';
			}

			ans = 0;
			cal(0, 0);
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}

	static void cal(int cnt, int cur) {
		if (cnt == k) {
			ans = Math.max(ans, parse(numArr));
			return;
		} else {
			for (int i = 0; i < n.length(); i++) {
				for (int j = 0; j < n.length(); j++) {
					if (i == j) {
						continue;
					} else {
						if (numArr[i] <= numArr[j]) {
							swap(i, j);
							cal(cnt + 1, i);
							swap(i, j);
						}
					}
				}
			}
		}

	}

	static int parse(int[] arr) {
		int temp = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			temp += Math.pow(10, arr.length - 1 - i) * arr[i];
		}
		return temp;
	}

	static void swap(int i, int j) {
		int temp = numArr[i];
		numArr[i] = numArr[j];
		numArr[j] = temp;
	}

}
