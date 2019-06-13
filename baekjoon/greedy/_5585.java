package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5585 { // 거스름돈 : http://www.acmicpc.net/problem/5585

	/**
	 *  11047 동전0 문제와 거의 같은 문제.
	 */
	
	static int price, change;
	static int[] coin = { 500, 100, 50, 10, 5, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		price = Integer.parseInt(br.readLine());
		change = 1000 - price;

		int cnt = 0;
		for (int i = 0; i < coin.length; i++) {
			cnt += change / coin[i];
			change %= coin[i];
		}
		System.out.println(cnt);
	}

}
