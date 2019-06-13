// https://www.acmicpc.net/problem/2440
package basic;

import java.util.*;

public class boj2440 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
