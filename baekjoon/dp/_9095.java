package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9095 { // 1,2,3 더하기 : https://www.acmicpc.net/problem/9095

	static int test_case, n;
	static int[] d;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		test_case = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < test_case; t++) {

			n = Integer.parseInt(br.readLine());
			d = new int[n + 1];
			for (int i = 0; i <= n; i++) {
				if (i == 0) {
					d[0] = 0;
				} else if (i == 1) { // 1
					d[i] = 1;
				} else if (i == 2) { // 1+1, 2
					d[i] = 2;
				} else if (i == 3) { // 1+1+1, 1+2, 2+1, 3 
					d[i] = d[i - 1] + d[i - 2] + 1;
				} else {
					d[i] = d[i - 1] + d[i - 2] + d[i - 3];
				}
			}
			System.out.println(d[n]);
		}
	}

}
