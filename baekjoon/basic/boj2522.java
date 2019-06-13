package basic;

import java.util.*;

public class boj2522 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j < n - (i + 1)) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n; j++) {
				if (j < i + 1) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

}
