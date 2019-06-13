package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2156 { // 포도주 시식 : http://www.acmicpc.net/problem/2156 

	static int n;
	static int[] a;
	static int[][] d;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		a = new int[n+1];
		d = new int[n+1][3];
		
		for(int i = 1; i<=n;i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		d[1][0] = d[1][2] = 0;
		d[1][1] = a[1];
		
		for(int i = 2;i<=n;i++) {
			d[i][0] = Math.max(d[i-1][0], Math.max(d[i-1][1], d[i-1][2]));
			d[i][1] = d[i-1][0]+a[i];
			d[i][2] = d[i-1][1]+a[i];
		}
		int ans = Math.max(d[n][0], Math.max(d[n][1], d[n][2]));
		System.out.println(ans);
	}

}
