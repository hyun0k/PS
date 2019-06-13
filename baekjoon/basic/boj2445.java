package basic;

import java.util.*;

public class boj2445 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2 * n; j++) {
				if (j < i + 1 || j > 2 * n - (i + 2)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		for (int i = n; i > 1; i--) {
			for (int j = 0; j < 2 * n; j++) {
				if (j < i - 1 || j > 2 * n - i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

}
