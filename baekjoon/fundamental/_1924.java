package fundamental;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1924 { // 2007년 : http://www.acmicpc.net/problem/1924
	/**
	 * 1월 1일부터 며칠이 지났는지를 카운트해서 7로 나눈 나머지를 이용하여 요일을 구한다. 
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int cntOfDays = 0;

		int[] mList = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		for (int i = 0; i < m - 1; i++) {
			cntOfDays += mList[i];
		}
		cntOfDays += d;

		switch (cntOfDays % 7) {
		case 1:
			System.out.println("MON");
			break;
		case 2:
			System.out.println("TUE");
			break;
		case 3:
			System.out.println("WED");
			break;
		case 4:
			System.out.println("THU");
			break;
		case 5:
			System.out.println("FRI");
			break;
		case 6:
			System.out.println("SAT");
			break;
		case 0:
			System.out.println("SUN");
			break;

		}
	}

}
