// https://www.acmicpc.net/problem/2444
package basic;

import java.util.*;

public class boj2444 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n + i; j++) {
				if (j < n - (i + 1)) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		for (int i = n; i > 0; i--) {
			for (int j = 0; j < n + (i - 2); j++) {
				if (j <= n - i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}

	}

}
