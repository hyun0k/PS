// https://www.acmicpc.net/problem/8393
package basic;

import java.util.*;

public class boj8393 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n, s;
		n = sc.nextInt();
		s = 0;
		for (int i = 1; i <= n; i++) {
			s += i;
		}
		System.out.println(s);
	}

}
