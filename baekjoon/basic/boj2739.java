// https://www.acmicpc.net/problem/2739 
package basic;

import java.util.*;

public class boj2739 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int dan;
		dan = sc.nextInt();
		for (int i = 1; i <= 9; i++) {
			System.out.println(String.format("%d * %d = %d", dan, i, dan * i));
		}
	}

}
