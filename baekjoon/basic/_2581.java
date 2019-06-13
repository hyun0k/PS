package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _2581 { // 소수 : http://www.acmicpc.net/problem/2581

	static int m, n;
	static ArrayList<Integer> primeN;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		m = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		primeN = new ArrayList<Integer>();

		while (m <= n) {
			int temp = m;
			boolean isPrime = true;
			if (temp == 1) {
				isPrime = false;
			} else {
				for (int i = 2; i < temp; i++) {
					if (temp % i == 0) {
						isPrime = false;
						break;
					}
				}
			}
			if (isPrime) {
				primeN.add(temp);
			}
			m++;
		}

		if (primeN.isEmpty()) {
			System.out.println(-1);
		} else {
			int sum = 0;
			for (int i = 0; i < primeN.size(); i++) {
				sum += primeN.get(i);
			}
			System.out.println(sum);
			System.out.println(primeN.get(0));
		}

	}

}
