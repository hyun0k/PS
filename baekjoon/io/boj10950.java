package io;
import java.util.*;

public class boj10950 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T, a, b, cnt;
		T = sc.nextInt();
		cnt = 0;
		while(cnt<T) {
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.println(a+b);
			cnt++;
		}
	}
}
