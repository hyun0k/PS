package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1547 { // 공 : http://www.acmicpc.net/problem/1547

	static int m, x, y;
	static int[] cups;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		m = Integer.parseInt(br.readLine());
		cups = new int[4];

		cups[1] = 1;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			if (x == y) {
				continue;
			} else {
				int temp = cups[x];
				cups[x] = cups[y];
				cups[y] = temp;
			}
		}
		for (int i = 1; i <= 3; i++) {
			if (cups[i] == 1) {
				System.out.println(i);
			}
		}
	}

}
