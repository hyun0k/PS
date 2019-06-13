package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2193 { // 이친수 : http://www.acmicpc.net/problem/2193

	static long[][] d;
	static int n;
	static long ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		d = new long[n+1][2];
		
		d[1][0]=0;
		d[1][1]=1;
		
		for(int i=2;i<=n;i++) {
			d[i][0] = d[i-1][0] + d[i-1][1];
			d[i][1] = d[i-1][0];
		}
		
		ans = d[n][0] + d[n][1];
		System.out.println(ans);
	}

}
