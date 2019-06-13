package fundamental;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1110 { // 더하기 사이클 : http://www.acmicpc.net/problem/1110

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		int temp = n;

		while (true) {
			int tenth = temp / 10;
			int units = temp % 10;
			if (tenth + units < 10) {
				temp = units * 10 + (tenth + units);
			} else {
				temp = units * 10 + (tenth + units) % 10;
			}
			cnt++;
			if (temp == n) {
				break;
			}
		}

		System.out.println(cnt);

	}

}
