import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1463 {
	static int[] d;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		d = new int[n+1];
	
		d[0] = d[1] = 0;
		for(int i = 2; i<=n; i++) {
			d[i] = d[i-1] + 1;
			if(i%3==0) {
				d[i] = Math.min(d[i], d[n/3]+1);
			}
			if(i%2==0) {
				d[i] = Math.min(d[i], d[n/2]+1);
			}
		}
		System.out.println(d[n]);
	}

}
