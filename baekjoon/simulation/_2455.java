package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2455 { // 지능형 기차 : http://www.acmicpc.net/problem/2455

	static int[][] a = new int[4][2];
	static int[] passenger = new int[4];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		/**
		 * 	int cur = 0;
			int max = 0;
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				int out = Integer.parseInt( st.nextToken() );
				int in = Integer.parseInt( st.nextToken() );
				cur += (in-out);
				if(cur > max) max = cur;
		}
		 */
		
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		passenger[0] = a[0][1];
		for (int i = 1; i < 4; i++) {
			passenger[i] = passenger[i - 1] - a[i][0] + a[i][1];
		}

		System.out.println(max(passenger));
	}

	static int max(int[] a) {
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		return max;
	}

}
