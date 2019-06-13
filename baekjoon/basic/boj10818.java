// https://www.acmicpc.net/problem/10818
package basic;

import java.util.*;

public class boj10818 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		while (n < 1 || n > 1000000) {
			System.out.println("1부터 1,000,000 사이의 정수를 입력하세요. ");
			n = sc.nextInt();
		}
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {			
				a[i] = sc.nextInt();			
		}
		int max = -1000000;
		int min = 1000000;
		for (int j = 0; j < n; j++) {
			max = Math.max(max, a[j]);
			min = Math.min(min, a[j]);
		}
		System.out.print(String.format("%d %d", min, max));
	}

}
